package algorithms.sort;

import java.util.Arrays;

/**
 * 选择排序
 * O(n^2) 和冒泡一样, 冒泡是把大的放尾巴, 选择是把小的放头
 * @author liuxiaokang
 * @date 2021/2/19
 */
public class SelectSort {
    
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    
    public static void selectSort(int[] arr) {
        // 需要arr.length - 1趟(3个数需要2趟)
        for (int i = 0; i < arr.length - 1; i++) {
            // 获取最小值
            int min = arr[i];
            // 最小值的索引
            int targetIndex = i;
            // 每趟的第一个不用管,第一个是最小的
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    targetIndex = j;
                }
            }
            // 交换最小值和当前趟的第一个数
            arr[targetIndex] = arr[i];
            arr[i] = min;
            System.out.println("第" + (i + 1) + "趟排序结果:" + Arrays.toString(arr));
        }
    }
}
