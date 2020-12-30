package datastructures.stack;

/**
 * 两个栈实现计算器
 */
public class Calculator {

	public static void main(String[] args) {
		String expression = "7*2*2-5+1-5+3-4";
		// 数字栈
		ArrayStack2 numStack = new ArrayStack2(10);
		// 符号栈
		ArrayStack2 operStack = new ArrayStack2(10);
		int index = 0;
		int num1 = 0; 
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		// 变量存储多位的数字
		String keepNum = "";
		while(true) {
			ch = expression.substring(index, index+1).charAt(0);
			if(operStack.isOper(ch)) {
				if(!operStack.isEmpty()) {
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						numStack.push(res);
						operStack.push(ch);
					} else {
						operStack.push(ch);
					}
				}else {
					operStack.push(ch); // 1 + 3
				}
			} else {
				keepNum += ch;
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				}else{
					if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";
						
					}
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);//��ջ
		}
		int res2 = numStack.pop();
		System.out.printf(" %s = %d", expression, res2);
	}

}

class ArrayStack2 {
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	public int peek() {
		return stack[top];
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("ջ�գ�û������~");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ�գ�û������~~");
			return;
		}
		for(int i = top; i >= 0 ; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	public int priority(int oper) {
		if(oper == '*' || oper == '/'){
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1; // �ٶ�Ŀǰ�ı��ʽֻ�� +, - , * , /
		}
	}
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	
	public int cal(int num1, int num2, int oper) {
		int res = 0; // res ���ڴ�ż���Ľ��
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;// ע��˳��
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
	
}
