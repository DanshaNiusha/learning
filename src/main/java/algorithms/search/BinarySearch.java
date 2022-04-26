package algorithms.search;


/**
 * 二分查找
 * @author liuxiaokang
 * @date 2021/1/26
 */
public class BinarySearch {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        // int index = binarySearchNoRecur(arr, 8);
        int index = binarySearch(arr, 8, 0, arr.length - 1);
        System.out.println(index);
    }
    
    /**
     * (递归实现)
     * @param arr    需要查找的数组
     * @param target 要查的数
     * @return 返回数的下标, -1代表没找到
     */
    public static int binarySearchNoRecur(int[] arr, int target) {
        // 左指针
        int left = 0;
        // 右边指针
        int right = arr.length - 1;
        while (left <= right) {
            // 中点索引
            int midIndex = (left + right) >>> 1; // 无符号位移1为就是/2
            // 中点值
            int midValue = arr[midIndex];
            if (midValue == target) {
                return midIndex;
            } else if (target < midValue) { // 在左边就把右指针指向中点
                right = midIndex - 1;// 因为比中点值小了,所以要中点-1
            } else {// 在右边就把左指针指向中点
                left = midIndex + 1;
            }
        }
        return -1;
    }
    
    
    
    /**
     * (非递归实现)
     * @param left 左指针
     * @param right 右边指针
     * @param arr    需要查找的数组
     * @param target 要查的数
     * @return 返回数的下标, -1代表没找到
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // 左边超过右边代表没找到
        if (left > right) {
            return -1;
        }
        // 中点索引
        int midIndex = (left + right) >>> 1; // 无符号位移1为就是/2
        // 中点值
        int midValue = arr[midIndex];
        if (midValue == target) {
            return midIndex;
        } else if (target < midValue) {
            return binarySearch(arr, target, left, midIndex - 1);
        } else {
            return binarySearch(arr, target, midIndex + 1, right);
        }
    }
    
    
}
