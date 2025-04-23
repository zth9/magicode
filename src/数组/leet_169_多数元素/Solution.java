package 数组.leet_169_多数元素;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tian
 * @date 2025-04-17
 */
public class Solution {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [3,2,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     *
     *
     * 提示：
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     *
     *
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     */
    public int majorityElement(int[] nums) {
        // 可以 work 但是空间复杂度较高、且多出 map 的两个操作
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int c = map.getOrDefault(num, 0) + 1;
            if (c > nums.length / 2) {
                return num;
            }
            map.put(num, c);
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        // 投票算法
        int count = 0; // 记录候选人票数
        int candidate = 0; // 记录候选人
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}
