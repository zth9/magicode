package 数组.leet_912_排序数组.归并排序;

/**
 * @author: theTian
 * @date: 2020/9/30 16:48
 */
public class Solution {
    /**
     * 对数组nums进行归并排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    /**
     * 将数组分半 递归合并
     *
     * @param nums
     * @param p
     * @param q
     * @return
     */
    private int[] merge(int[] nums, int p, int q) {
        if (p >= q) {
            return new int[]{nums[p]};
        }
        int[] arr1 = merge(nums, p, (p + q) / 2);
        int[] arr2 = merge(nums, (p + q) / 2 + 1, q);
        return mergeArray(arr1, arr2);
    }

    /**
     * 合并两个有序数组
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private int[] mergeArray(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int p = 0;
        int q = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr1.length == p) {
                res[i] = arr2[q++];
            } else if (arr2.length == q) {
                res[i] = arr1[p++];
            } else {
                if (arr1[p] < arr2[q]) {
                    res[i] = arr1[p++];
                } else {
                    res[i] = arr2[q++];
                }
            }
        }
        return res;
    }
}
