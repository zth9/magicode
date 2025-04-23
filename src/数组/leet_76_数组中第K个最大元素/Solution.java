package 数组.leet_76_数组中第K个最大元素;

/**
 *
 * @author tian
 * @date 2025-04-03
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int begin, int end, int k) {
        int p = partition(nums, begin, end);
        if (p == nums.length - k) {
            return nums[p];
        }
        if (p > (nums.length - k)) {
            return quickSort(nums, begin, p - 1, k);
        } else {
            return quickSort(nums, p + 1, end, k);
        }
    }

    private int partition(int[] nums, int begin, int end) {
        if (begin >= end) return begin;
        int p = nums[begin];
        int i = begin + 1;
        while (i <= end) {
            int tmp = nums[i];
            if (nums[i] <= p) {
                nums[i++] = nums[begin];
                nums[begin++] = tmp;
            } else {
                nums[i] = nums[end];
                nums[end--] = tmp;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[] {1,3,2,4,9,8,7,6}, 9));
    }
}
