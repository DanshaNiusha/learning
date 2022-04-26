import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
    
    
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        while(left<=right){
            int mid = left+(right-left)/2;
            long midqart = (long)mid*mid;
            
            if(midqart>x){ //x/m<m而不是m*m>x
                right = mid-1;
            } else if(midqart<x){
                left =mid+1;
            } else{
                return mid;
            }
            if(midqart<x && ((long) (mid + 1) *(mid+1))>x){
                return mid;
            }
        }
        return -1;
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        int left = 0;
        int right = nums.length - 1;
        
        boolean leftFound = false;
        boolean rightFound = false;
        while (left <= right) {
            if (!leftFound && nums[left] == target) {
                ans[0] = left;
                leftFound = true;
            }
            
            if (!rightFound && nums[right] == target) {
                ans[1] = right;
                rightFound = true;
            }
            if (!leftFound) {
                left++;
            }
            if (!rightFound) {
                right--;
            }
            if (leftFound && rightFound){
                break;
            }
         
        }
        return ans;
    }
}