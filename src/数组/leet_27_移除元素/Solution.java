package 数组.leet_27_移除元素;

/**
 * @author: theTian
 * @date: 2020/10/9 18:45
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        for (int i = 0; i <= last; i++) {
            if (nums[i] == val) nums[i--] = nums[last--];
        }
        return last + 1;
    }
}
