package 数组.leet_1_两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: theTian
 * @date: 2020/9/27 19:59
 */
public class Solution {
    /**
     * @param nums 给定的整数数组
     * @param target 目标和
     * @return int[]数组 包含两个和为target的元素的下标
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { // 存在和为target的两个元素
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i); // 如未找到就添加进map
        }
        return null;
    }
}
