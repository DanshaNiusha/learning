package algorithms.dac;

/**
 * 分治算法解决汉诺塔问题(三个棍移盘子,大的在下小的在上)
 * @author liuxiaokang
 * @date 2021/1/27
 */
public class HanoiTower {
    
    public static void main(String[] args) {
        hanoitowerSoluation( 3, 'A', 'B', 'C');
    }
    
    
    /**
     *
     * @param num 盘子的数量
     * @param a 塔a 起始地
     * @param b 塔b 辅助地
     * @param c 塔c 目的地
     */
    private static void hanoitowerSoluation(int num, char a, char b, char c) {
        if (num == 1) {
            // 只剩一个盘
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            // n>2的时候总看成2个盘,最下面一个,上是一个
            // 每次移动减一个盘子, c是目的地, 先把a中除了最后一个都移到b上
            hanoitowerSoluation(num - 1, a, c, b);
            // 第一个递归结束后最大的已经在c上了, 其他的全在b上
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            hanoitowerSoluation(num - 1, b, a, c);
        }
    
    }
    
    
    
}
