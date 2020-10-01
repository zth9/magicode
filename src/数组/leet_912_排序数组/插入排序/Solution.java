package 数组.leet_912_排序数组.插入排序;

import java.util.Arrays;

/**
 * @author: theTian
 * @date: 2020/9/30 15:52
 */
public class Solution {
    /**
     * 插入排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) <= 1) {
            return nums;
        }
        for (int i = 1; i < length; i++) {
            int curNum = nums[i];
            int targetIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (curNum < nums[j]) {
                    targetIndex = j;
                } else {
                    break;
                }
            }
            if (targetIndex != i) {
                for (int j = i; j > targetIndex ; j--) {
                    nums[j] = nums[j-1];
                }
                nums[targetIndex] = curNum;
            }
        }
        return nums;
    }
}
