package 数组.leet_121_买卖股票的最佳时机;

/**
 *
 * @author tian
 * @date 2025-04-18
 */
public class Solution {

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     *
     * 提示：
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */
    public int maxProfit(int[] prices) {
        // O(n) / O(1)
        // 贪心
        // 从第一天开始，记录最小股价 valley
        // 用当天股价 prices[i]，减去过去所有时间的最小股价 valley，得到当天卖出的最大利润 profit
        // 比较每天卖的利润，最后得到最大利润
        int profit = 0;
        for (int i = 0, valley = prices[i]; i < prices.length; i++) {
            valley = Math.min(valley, prices[i]);
            profit = Math.max(profit, prices[i] - valley);
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        // O(n) / O(n)
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit3(int[] prices) {
        // 动态规划 节省空间 简化版
        //
        // O(n) / O(1)
        int len = prices.length;
        int profit = 0;
        // 前一天卖出可以获得的最大利润
        int pre = 0;
        for (int i = 1; i < len; i++) {
            // 利润差
            int diff = prices[i] - prices[i - 1];
            // 状态转移方程：第i天卖出可以获得的最大利润 = 第i-1天卖出的最大利润 + 利润差
            pre = Math.max(pre + diff, 0);
            profit = Math.max(profit, pre);
        }
        return profit;
    }
}
