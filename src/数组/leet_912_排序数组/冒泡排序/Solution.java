package 数组.leet_912_排序数组.冒泡排序;

import java.util.Arrays;

/**
 * @author: theTian
 * @date: 2020/9/30 15:15
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] ints = new Solution().sortArray(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 冒泡排序 时间复杂度n~n^2（加入flag优化）
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) <= 1) {
            return nums;
        }
        for (int i = 0; i < length - 1; i++) {
            boolean change = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
        return nums;
    }
}
