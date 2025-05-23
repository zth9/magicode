package 动规.leet_62_不同路径;

/**
 *
 * @author tian
 * @date 2025-04-22
 */
public class Solution {

    /**
     * 62. 不同路径
     * 中等
     * 相关标签
     * 相关企业
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     *
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * 示例 3：
     *
     * 输入：m = 7, n = 3
     * 输出：28
     * 示例 4：
     *
     * 输入：m = 3, n = 3
     * 输出：6
     *
     *
     * 提示：
     *
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 109
     * 面试中遇到过这道题?
     * 1/5
     * 是
     * 否
     * 通过次数
     * 981.6K
     * 提交次数
     * 1.4M
     * 通过率
     * 69.4%
     * 相关标签
     */

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int i = uniquePaths(3, 2);
        System.out.println(i);
    }
}
