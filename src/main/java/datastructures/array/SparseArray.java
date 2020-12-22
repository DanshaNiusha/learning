package datastructures.array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 稀疏数组和二维数组转换
 *
 * 课后练习
 * 1) 在前面的基础上，将稀疏数组保存到磁盘上，比如 map.data
 * 2) 恢复原来的数组时，读取 map.data 进行恢复
 */
public class SparseArray {
    public static void main(String[] args) throws IOException {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 黑子 2 蓝子
        
        // 创建11x11的棋盘
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1; //2行3列
        chessArr1[2][3] = 5; //3行4列
        chessArr1[4][5] = 7; //5行6列
        
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
        // 存储稀疏数组的行数
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    ++count;
                    // 稀疏数组前两列存的是非0值的位置
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        
        File file = new File("D:\\liuxiaokang\\map.data");
        FileWriter writer = new FileWriter(file);
        System.out.println("稀疏数组打印~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            //将稀疏数组保存到磁盘
            writer.write(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2]);
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            writer.write("\r\n");
        }
        writer.close();
        System.out.println();
    
        /**
         * 将稀疏数组恢复为二维数组
         */
        // 读取map.data
        int[][] sparseArr_new = new int[sum + 1][3];
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int row = 0;
        while ((line=reader.readLine())!=null){
            String[] split = line.split("\t");
            sparseArr_new[row][0] = Integer.parseInt(split[0]);
            sparseArr_new[row][1] = Integer.parseInt(split[1]);
            sparseArr_new[row][2] = Integer.parseInt(split[2]);
            row++;
        }
        
    
        System.out.println("稀疏数组恢复为二维数组");
        int rows = sparseArr_new[0][0];
        int cols = sparseArr_new[0][1];
        int[][] arr = new int[rows][cols];
        for (int i = 1; i < sparseArr_new.length; i++) {
            arr[sparseArr_new[i][0]][sparseArr_new[i][1]] = sparseArr_new[i][2];
        }
        
        for (int[] ints : arr) {
            for (int data : ints) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        
        
    }
    
}
