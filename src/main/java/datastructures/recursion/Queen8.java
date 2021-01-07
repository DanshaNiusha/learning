package datastructures.recursion;

/**
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于
 * 1848 年提出：在 8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，即： 任意两个皇后都不能处于同一行 、
 * 同一列或同一斜线上，问有多少种摆法(92)
 *
 * 八皇后问题算法思路分析
 * 1) 第一个皇后先放第一行第一列
 * 2) 第二个皇后放在第二行第一列、然后判断是否 OK， 如果不 OK，继续放在第二列、第三列、依次把所有列都
 * 放完，找到一个合适
 * 3) 继续第三个皇后，还是第一列、第二列……直到第 8 个皇后也能放在一个不冲突的位置，算是找到了一个正确
 * 解
 * 4) 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，
 * 全部得到.
 * 5) 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4 的步骤
 *
 * 理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题. arr[8] =
 * {0 , 4, 7, 5, 2, 6, 1, 3} //对应 arr 下标 表示第几行，即第几个皇后，arr[i] = val , val 表示第 i+1 个皇后，放在第 i+1
 * 行的第 val+1 列
 *
 */
public class Queen8 {
    // 1,定义有几个皇后
    int max = 8;
    // 2.定义保存位置的数组
    int[] arr = new int[max];
    
    static int count = 0;
    static int judgeCount = 0;
    
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
    }
    
    /**
     * 放置第n个皇后
     */
    private void check(int n) {
        // 从0开始放, 如果n=8代表是第九个, 8皇后已经放好
        if (n == 8) {
            // 每次n=8 代表第一轮8皇后放完, 打印之
            print();
            return;
        }
        // 依次放置8个皇后
        for (int i = 0; i < max; i++) {
            // 放置第n个皇后到[n,i]
            arr[n] = i;
            // 判断当前位置是否可用, 可用就继续放下一个, 不可用就循环i++, 继续尝试本行的下一列
            if (judge(n)) {
                check(n + 1);
            }
        }
        
    }
    
    
    
    /**
     * 当放第n个皇后的时候检测前n-1个皇后是否和n冲突
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 同一列冲突 || 两个点之间行行和列列之间距离是否相等(斜率是否为1) 相等就是在一条斜线上就冲突了
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }
    
    /**
     *
     * 打印
     */
    private void print() {
        ++count;
        for (int i : arr) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }
}
