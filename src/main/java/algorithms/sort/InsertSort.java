package algorithms.sort;

import java.util.Arrays;

/**
 * 插入排序 类似于抓牌,插牌 把数组分为已排序和未排序两部分,每次拿到数就插到合适的位置, 然后把后面的数依次后移
 * @author liuxiaokang
 * @date 2021/2/19
 */
public class InsertSort {
    
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int maxSortedIndex = i - 1;
            int insertVal = arr[i];
            int maxSortedVal = arr[maxSortedIndex];
            
            //     前移时候不越界         待插入的值比已排序部分中最大的值小, 证明前面的需要给他挪位置
            while (maxSortedIndex >= 0 && insertVal < maxSortedVal) {
                // 已排序部分依次向后挤一个, 直到找到位置
                arr[maxSortedIndex + 1] = arr[maxSortedIndex];
                maxSortedIndex--;
            }
            // 此时maxSortedIndex就是目标位置的前一个, 在这个后面插入
            arr[maxSortedIndex + 1] = insertVal;
    
            System.out.println("第" + (i) + "趟排序结果:" + Arrays.toString(arr));
        }
    }
}
