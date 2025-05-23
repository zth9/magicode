package 数组.leet_912_排序数组.快速排序;

import java.util.Arrays;

/**
 * @author tian
 * @date 2025-04-03
 */
public class Solution {
    /**
     * 对nums进行快速排序
     * 快排是不稳定原地排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int p = partition(nums, begin, end);
        quickSort(nums, begin, p - 1);
        quickSort(nums, p + 1, end);
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
        System.out.println(Arrays.toString(new Solution().sortArray(new int[] {1,3,2,4,9,8,7,6,-1, -3, -2, 100 ,22, 66, 33,77, 88,55,54,56})));
    }
}
