package 动规._背包问题._01背包;

/**
 *
 * @author tian
 * @date 2025-04-22
 */
public class Solution {

    public static int maxV(int[] wei, int[] val, int cap) {
        int[][] dp = new int[wei.length + 1][cap + 1];
        for (int i = 1; i <= wei.length; i++) {
            int w = wei[i - 1];
            for (int c = 1; c <= cap; c++) {
                if (w > c) {
                    dp[i][c] = dp[i - 1][c];
                } else {
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - w] + val[i - 1]);
                }
            }
        }
        return dp[wei.length][cap];
    }

    public static void main(String[] args) {
        int i = maxV(new int[]{10, 20, 30, 40, 50}, new int[]{50, 120, 150, 210, 240}, 50);
        System.out.println(i);
    }
}
