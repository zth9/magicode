package 数组.leet_912_排序数组.交换排序;

/**
 * @author: theTian
 * @date: 2020/9/30 15:28
 */
public class Solution {
    /**
     * 交换排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) <= 1) {
            return nums;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return nums;
    }
}
