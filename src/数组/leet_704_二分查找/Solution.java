package 数组.leet_704_二分查找;

/**
 * @author: theTian
 * @date: 2020/10/3 16:35
 */
public class Solution {
    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int length;
        if (nums == null || (length = nums.length) < 1) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        for (;;) {
            if (left > right){
                return -1;
            }
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
    }
}
