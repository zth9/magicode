package 数组.leet_494_目标和;

import java.awt.desktop.PreferencesEvent;

/**
 *
 * @author tian
 * @date 2025-04-22
 */
public class Solution2 {

    /**
     * 494. 目标和
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个非负整数数组 nums 和一个整数 target 。
     *
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     * 示例 2：
     *
     * 输入：nums = [1], target = 1
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 20
     * 0 <= nums[i] <= 1000
     * 0 <= sum(nums[i]) <= 1000
     * -1000 <= target <= 1000
     */
    public static int findTargetSumWays(int[] nums, int target) {
        // dp


        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int bp = (target + sum) / 2;

        // dp[i, t] = dp[i - 1, t - nums[i - 1]] + dp [i - 1, t + nums[i - 1]]
        // 特殊的：dp[0, t] = nums[0] == t ? 1 : 0 + -nums[0] == t ? 1 : 0;
        // 求解 dp[nums.length, target]

        return 1;

    }

    public static void main(String[] args) {
        int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
