package 数组.leet_35_搜索插入位置;

/**
 * @author: theTian
 * @date: 2020/10/11 18:53
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) return 0;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
