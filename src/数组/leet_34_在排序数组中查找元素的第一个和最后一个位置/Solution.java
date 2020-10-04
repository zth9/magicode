package 数组.leet_34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * @author: theTian
 * @date: 2020/10/3 19:34
 */
public class Solution {
    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left <= nums.length - 1 && nums[left] == target) {
            res[0] = left;
        }else {
            return new int[]{-1,-1};
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }
}
