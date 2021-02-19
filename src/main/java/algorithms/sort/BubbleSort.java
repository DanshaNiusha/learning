package algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * O(n^2)
 * @author liuxiaokang
 * @date 2021/2/19
 */
public class BubbleSort {
    
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        // int[] arr = {-1, -2, 3, 9, 10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    
    public static void bubbleSort(int[] arr) {
        // 优化, 如果在某趟排序中没有进行任何交换, 那么数组已经是有序的了, 直接结束
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            // 一个fori循环是1趟 第一趟把最大的放到最后, 第二趟把最大的放到倒数第二, 已经排好的不参与比较(每次排一个, 最多arr.length-1趟完成)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 发生交换就变true
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                // 发生了交换,重置flag
                flag = false;
            }
            System.out.println("第" + (i + 1) + "趟排序结果:" + Arrays.toString(arr));
        }
    }
    
    
}
