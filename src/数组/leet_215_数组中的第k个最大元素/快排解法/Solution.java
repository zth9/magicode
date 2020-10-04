package 数组.leet_215_数组中的第k个最大元素.快排解法;

/**
 * @author: theTian
 * @date: 2020/10/3 13:01
 */
public class Solution {
    /**
     * 找到数组中第k大的元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return getK(nums, k, 0, nums.length - 1);
    }

    private int getK(int[] nums, int k, int p, int r) {
        if (p>r){
            return nums[p];
        }
        int q = partition(nums, p, r);
        if (nums.length-q == k){
            return nums[q];
        }
        if (nums.length-q < k){
            return getK(nums, k, p, q-1);
        }else {
            return getK(nums, k, q+1, r);
        }
    }

    private int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int bigIndex = p;
        for (int i = p; i < r; i++) {
            if (nums[i]<pivot){
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
