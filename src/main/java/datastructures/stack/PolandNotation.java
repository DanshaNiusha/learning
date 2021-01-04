package datastructures.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器 给定逆波兰表达式, 计算结果, 就是计算机底层的计算方式 后缀表达式比中缀表达式更适合栈的运算
 * <p>
 * 1) 输入一个逆波兰表达式(后缀表达式)，使用栈(Stack), 计算其结果
 * 2) 支持小括号和多位数整数，因为这里我们主要讲的是数据结构，因此计算器进行简化，只支持 对整数的计算。
 * 3) 思路分析
 * 例如: (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - , 针对后缀表达式求值步骤如下:
 * 1．从左至右扫描，将 3 和 4 压入堆栈；
 * 2．遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
 * 3．将 5 入栈；
 * 4．接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
 * 5．将 6 入栈；
 * 6．最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
 */
public class PolandNotation {
    
    public static void main(String[] args) {
        //先定义给逆波兰表达式
        //(30+4)×5-6 => 30 4 + 5 × 6 - => 164
        // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
        //测试
        //说明为了方便，逆波兰表达式 的数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 -";
        // String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        //思路
        //1. 先将 "3 4 + 5 × 6 - " => 放到 ArrayList 中
        //2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList=" + list);
        int res = calculate(list);
        System.out.println("计算的结果是=" + res);
    }
    
    //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList 中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, split);
        return list;
    }
    
    
    /*
     完成对逆波兰表达式的运算
     (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 -
     1)从左至右扫描，将 3 和 4 压入堆栈；
     2)遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
     3)将 5 入栈；
     4)接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
     5)将 6 入栈；
     6)最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
    */
    public static int calculate(List<String> ls) {
        // 创建给栈, 只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        // 遍历 ls
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else {
                // pop 出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                //把 res 入栈
                stack.push(String.valueOf(res));
            }
        }
        //最后留在 stack 中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
    
    
    /**
     * 中缀表达式转换为后缀表达式
     * 具体步骤如下:
     * 1) 初始化两个栈：运算符栈 s1 和储存中间结果的栈 s2；
     * 2) 从左至右扫描中缀表达式；
     * 3) 遇到操作数时，将其压 s2；
     * 4) 遇到运算符时，比较其与 s1 栈顶运算符的优先级：
     *      1.如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     *      2.否则，若优先级比栈顶运算符的高，也将运算符压入 s1；
     *      3.否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较；
     * 5) 遇到括号时：
     *      (1) 如果是左括号“(”，则直接压入 s1
     *      (2) 如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6) 重复步骤 2 至 5，直到表达式的最右边
     * 7) 将 s1 中剩余的运算符依次弹出并压入 s2
     * 8) 依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */

    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
    
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
    
        return s2;
    
    }
    
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;
    
    //дһ�����������ض�Ӧ�����ȼ�����
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("�����ڸ������" + operation);
                break;
        }
        return result;
    }
    
}