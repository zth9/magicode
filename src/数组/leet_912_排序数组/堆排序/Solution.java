package 数组.leet_912_排序数组.堆排序;
/**
 * @author: theTian
 * @date: 2020/10/8 20:09
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        if (length<2) return nums;
        heapSort(nums, length - 1);
        return nums;
    }
    private void heapSort(int[] nums, int last) {
        // 初始化堆
        int h = last / 2; // 完全二叉树最后一个非叶子节点索引
        while (h >= 0) heapfy(nums, h--, last);
        // 排序
        while (last != 0){
            swap(nums, 0, last--); // 首位交换
            heapfy(nums, 0, last); // 堆化
        }
    }
    private void heapfy(int[] nums, int root, int last) {
        while (true) {
            int left = root * 2 + 1;
            int right = root * 2 + 2;
            int maxPos = root;
            if (left <= last && nums[root] < nums[left]) maxPos = left;
            if (right <= last && nums[maxPos] < nums[right]) maxPos = right;
            if (maxPos == root) break;
            swap(nums, root, maxPos);
            root = maxPos;
        }
    }
    private void swap(int[] nums, int last, int parent) {
        int tmp = nums[last];
        nums[last] = nums[parent];
        nums[parent] = tmp;
    }
}
