package 数组.leet_912_排序数组.快速排序;

import java.util.Arrays;

/**
 * @author: theTian
 * @date: 2020/10/1 20:47
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

    private void quickSort(int[] nums, int p, int r) {
        if (p>=r){
            return;
        }
        int q = partition(nums, p, r);
        quickSort(nums, p, q-1);
        quickSort(nums, q+1, r);
    }

    private int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int bigIndex = p;
        for (int i = p; i < r; i++) {
            if (nums[i] < pivot){
                int tmp = nums[i];
                nums[i] = nums[bigIndex];
                nums[bigIndex++] = tmp;
            }
        }
        nums[r] = nums[bigIndex];
        nums[bigIndex] = pivot;
        return bigIndex;
    }
}
