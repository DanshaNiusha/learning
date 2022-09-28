package algorithms.dynamic;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 动态规划- 01背包问题 不能装重复的
 * 背包有个容量  不同的物品有不同的重量和价值, 求解出怎么组合能装出最高的价值,背包中的物品不能重复
 * 1) 要求达到的目标为装入的背包的总价值最大，并且重量不超出
 * 2) 要求装入的物品不能重复
 *
 * 物品	    0 磅	1磅	     2磅	 3磅	4磅
 * 没物品    0	    0	     0	     0	     0
 * 吉他(G)	0	    1500(G)	1500(G)	1500(G)	1500(G)
 * 音响(S)	0	    1500(G)	1500(G)	1500(G)	3000(S)
 * 电脑(L)	0	    1500(G)	1500(G)	2000(L)	2000(L)+1500(G)
 *
 * 公式
 * (1) v[i][0]=v[0][j]=0; //表示 填入表 第一行和第一列是0
 * (2) 当w[i]> j 时：v[i][j]=v[i-1][j] // 当准备加入新增的商品的容量大于 当前背包的容量时，就直接使用上一个单元格的装入策略
 * (3) 当j>=w[i]时： v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]}
 * @author liuxiaokang
 * @date 2021/1/27
 */
public class KnapasckProblem {
    
    
    public static void main(String[] args) {
        // 物品的重量
        int[] w = {1, 4, 3};
        // 物品的价值
        int[] val = {1500, 3000, 2000};
        // 背包的容量
        int m = 4;
        // 物品的个数
        int n = val.length;
        // 构建表矩阵 因为有一行和一列是0 所以+1
        int[][] v = new int[n + 1][m + 1];
        
        // 记录被放入商品的情况
        int[][] path = new int[n + 1][m + 1];
        
        // 初始化第一行和第一列
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
    
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        //根据公式来动态规划
        for (int i = 1; i < v.length; i++) { // 丢弃第一行 物品行
            for (int j = 1; j < v[0].length; j++) {// 丢弃第一列 重量 列
                if (w[i - 1] > j) { // 因为是从1开始遍历的 所以要减去1 (装不下 就装上一行的格子的)
                    v[i][j] = v[i - 1][j];
                } else if (w[i - 1] <= j) {
                    // v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);//后面的就是当前物品的价值+剩余上能装下的重量最值钱的 (表格天然就是按值钱的顺序排好的)
                    //为了存放商品存放到背包的情况, 不能使用上面的公式
                    if (val[i - 1] + v[i - 1][j - w[i - 1]] > v[i - 1][j]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
       
        // 输出矩阵
        Stream.of(v).forEach(x-> System.out.println(Arrays.toString(x)));
        
        // 输出放入的商品
        int i = path.length - 1;// 最后一行
        int j = path[0].length - 1; // 最后一列
        while(i > 0 && j > 0 ) { // 逆向遍历
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品被放入包包\n", i);
                j -= w[i-1]; //w[i-1]
            }
            i--;
        }
        
        
    }
    




}
