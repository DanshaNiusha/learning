package data_structures.sparseArray;

/**
 * 稀疏数组和二维数组转换
 * @author liuxiaokang
 * @date 2020/12/21
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 黑子 2 蓝子
        
        // 创建11x11的棋盘
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1; //2行3列
        chessArr1[2][3] = 1; //3行4列
        
        System.out.println("输出原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        
        /*
         *将二维数组 转 稀疏数组
         */
        System.out.println("将二维数组 转 稀疏数组");
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
    
        // 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 11行11列 sum个非零的值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 把值存到稀疏数组中
        sparseArr[1][0] = 1;
        sparseArr[1][1] = 2;
        sparseArr[1][2] = 1;
        sparseArr[2][0] = 2;
        sparseArr[2][1] = 3;
        sparseArr[2][3] = 1;
        
        
        
    }
    
}
