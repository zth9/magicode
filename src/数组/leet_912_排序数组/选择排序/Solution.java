package 数组.leet_912_排序数组.选择排序;

import java.util.Arrays;

/**
 * @author: theTian
 * @date: 2020/9/30 15:40
 */
public class Solution {
    /**
     * 选择排序 相较于交换排序 减少了大量的交换操作
     * 不稳定排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) <= 1) {
            return nums;
        }
        for (int i = 0; i < length - 1; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if (index != i) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}
