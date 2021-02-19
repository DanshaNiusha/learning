package algorithms.sort;

import java.util.Arrays;

/**
 * 希尔排序, 就是分组的插入排序, 防止特别小的数在最后, 导致移动的次数很多影响效率,做法: 先把数组划分成多个部分(设置一个步长,间隔一个步长的几个一组), 每个部分单独插排, 最后再整个进行一次插入排序即可
 * 插入排序 类似于抓牌,插牌 把数组分为已排序和未排序两部分,每次拿到数就插到合适的位置, 然后把后面的数依次后移
 * @author liuxiaokang
 * @date 2021/2/19
 */
public class ShellSort {
    
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    
    private static void shellSort(int[] arr) {
        int count = 0;
        // 先以步长arr.length / 2进行分组, 然后随着步长的减小, 组数也越来越少, 最后剩一个, 直接排序就完成了
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                // 移位 交换完之后再比较, 直接插到正确的位置
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j-gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            System.out.println("第" + (++count) + "趟排序结果:" + Arrays.toString(arr));
        }
    }
    
}
