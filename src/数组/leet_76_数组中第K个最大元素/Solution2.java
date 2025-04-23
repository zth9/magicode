package 数组.leet_76_数组中第K个最大元素;

import java.util.PriorityQueue;

/**
 *
 * @author tian
 * @date 2025-04-03
 */
public class Solution2 {

    /**
     * 堆排序
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
        }
        for (int i = 0; i < nums.length - k; i++) {
            heap.poll();
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().findKthLargest(new int[] {1,3,2,4,9,8,7,6}, 3));
    }
}
