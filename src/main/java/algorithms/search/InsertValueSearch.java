package algorithms.search;

/**
 * 插值查找 和二分查找一样 , 就是把mid从写死的/2变成了自适应的(拉格朗日中值定理), 二分的优化版 在均匀的数组中可以快速的定位
 * int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low])
 * 系数变化, key - arr[low]表示目标值比最小值大多少,如果相差很近, 那中点就会偏左 反之一样, 这样中点就会更接近目标值
 *
 * 插值查找注意事项：
 * 1) 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
 * 2) 关键字分布不均匀的情况下，该方法不一定比折半查找要好
 */
public class InsertValueSearch {
    
    
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = insertValueSearch(arr, 0, arr.length - 1, 8);
        System.out.println("index = " + index);
        
    }
    
    /**
     * 编写插值查找算法
     * 说明：插值查找算法，也要求数组是有序的
     *
     * @param arr         数组
     * @param left        左边索引
     * @param right       右边索引
     * @param targetValue 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int targetValue) {
        // 目标值不在范围内
        if (left > right || targetValue < arr[0] || targetValue > arr[arr.length - 1]) {
            return -1;
        }
        // 公式的自适应mid
        int mid = left + (right - left) * (targetValue - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        
        if (midVal == targetValue) {
            return mid;
        }
        if (targetValue > midVal) {
            return insertValueSearch(arr, mid + 1, right, targetValue);
        }
        if (targetValue < midVal) {
            return insertValueSearch(arr, left, mid - 1, targetValue);
        }
        
        return -1;
    }
    
}
