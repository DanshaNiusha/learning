package algorithms.sort;

import java.util.Arrays;

/**
 * 堆排序(树结构的应用) https://www.cnblogs.com/chengxiao/p/6129630.html
 * 1) 堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复
 * 杂度均为 O(nlogn)，它也是不稳定排序。
 * 2) 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆, 注意 : 没有
 * 要求结点的左孩子的值和右孩子的值的大小关系。
 * 3) 每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 *
 * 堆排序的基本思想是：
 * 1) 将待排序序列构造成一个大顶堆
 * 2) 此时，整个序列的最大值就是堆顶的根节点。
 * 3) 将其与末尾元素进行交换，此时末尾就为最大值。
 * 4) 然后将剩余 n-1 个元素重新构造成一个堆，这样会得到 n 个元素的次小值。如此反复执行，便能得到一个有序序列了
 *
 * 简单总结下堆排序的基本思路：
 * 1).将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
 * 3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，
 * 直到整个序列有序
 */
public class HeapSort {
    /**
     * 一个数组 {4,6,8,5,9} , 要求使用堆排序法，将数组升序排序。
     */
    public static void main(String[] args) {
        //要求将数组进行升序排序
        int[] arr = {10, 12, 4, 6, 8, 5, 9};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后=" + Arrays.toString(arr));
    }
    
    //编写一个堆排序的方法
    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序!!");
        
        // //分步完成
        // adjustHeap(arr, 1, arr.length);
        // System.out.println("第一次" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
        //
        // adjustHeap(arr, 0, arr.length);
        // System.out.println("第2次" + Arrays.toString(arr)); // 9,6,8,5,4
        
        //1).将无序序列构建成一个大顶堆，根据升序降序需求选择大顶堆或小顶堆
        // arr.length / 2 - 1 是二叉树的第一个非叶子节点 2i+1是节点的左子节点,+2是右节点
        // 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
        // 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
            // System.out.println(Arrays.toString(arr));
        }
		
		/*
		 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端,每一次堆调整就会保证堆顶的数最大或最小;
         * 3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
		 */
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        
    }
    
    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆 在一个小子树中排成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素进行调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //说明
        //1. k = i * 2 + 1 k 是 i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { //说明左子结点的值小于右子结点的值
                k++; // k 指向右子结点
            }
            if (arr[k] > temp) { //如果子结点大于父结点
                arr[i] = arr[k]; //把较大的值赋给当前结点
                i = k; //!!! i 指向 k,继续循环比较
            } else {
                break;//!
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的子树调整为了大顶堆(局部)
        arr[i] = temp;//将temp值放到调整后的位置
    }
    
}
