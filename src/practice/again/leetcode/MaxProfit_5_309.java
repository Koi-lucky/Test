package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/24 21:30
 */
public class MaxProfit_5_309 {

    public static int maxProfit(int[] prices) {
        // 动态规划算法
        // “买卖股票2”的进阶版 —— 加了个冷冻期
        // 所以j现在有三种状态：持有股票后的金钱数、不持有股票（能购买）的金钱数、不持有股票（冷冻期）的金钱数
        // 递推式推导：dp[i][0]有两个状态：一是无操作dp[i-1][0]，二是买入dp[i-1][1] - prices[i];
        // dp[i][1]由两种状态推出：一是无操作dp[i-1][1]，一是前天的冷冻期结束dp[i-1][2];
        // dp[i][2]只有一种状态:前一天卖出股票dp[i-1][0] + prices[i]
        // 初始化：dp[0][0]=-prices[i]; dp[i][1]=0; dp[i][2]=0

        // 特殊情况判断
        if (prices.length <= 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[prices.length -1 ][2], dp[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        // 测试
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
