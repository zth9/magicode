package 数组.leet_912_排序数组.归并排序;

import java.util.Arrays;

/**
 * @author: theTian
 * @date: 2020/9/30 16:48
 */
public class Solution {
    /**
     * 对数组nums进行归并排序
     * 稳定排序 但不是原地排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private int[] merge(int[] nums, int begin, int end) {
        int p = (end - begin) / 2 + begin;
        if (end == begin) {
            return new int[] {nums[begin]};
        }
        return merge(merge(nums, begin, p), merge(nums, p + 1, end));
    }

    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int p = 0, q = 0;
        for (int i = 0; i < res.length; i++) {
            if (p == a.length) {
                res[i] = b[q++];
            } else if (q == b.length) {
                res[i] = a[p++];
            } else if (a[p] <= b[q]) {
                res[i] = a[p++];
            } else {
                res[i] = b[q++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArray(new int[] {1,3,2,4,9,8,7,6})));
    }
}
