package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/24 21:44
 */
public class MaxProfit_6_714 {

    public static int maxProfit(int[] prices, int fee) {
        // 动态规划算法
        // “买卖股票2”的进阶 —— 每次购买后，加了一个手续费
        // 递推式的逻辑：dp[i][0]由两种状态推出：一是无操作dp[i-1][0]，二是买入dp[i-1][1] - prices[i]
        // dp[i][1]由两种状态推出：一是无操作dp[i-1][1]，二是卖出 - 手续费dp[i-1][0] + prices[i] - fee

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);// 买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);// 卖出+手续费
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        // 测试
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}
