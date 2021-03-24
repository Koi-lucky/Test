package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/24 17:51
 */
public class MaxProfit_2_122 {

    public static int maxProfit(int[] prices) {
        // 动态规划算法
        // 加了条件的买卖股票 —— 在原来的基础上卖出之后可以再次买入
        // 递推式的变化：dp[i][0]可以由两个方式获得：一个是前一天持有股票的金钱数dp[i-1][0]，一个是买入股票时还有昨天卖出的的利润dp[i-1][1]-prices[i]
        // dp[i][1]可以有两个方式获得：一是前一天不持有股票的金钱数dp[i-1][1]，一个是卖出股票后的金钱数dp[i-1][0]+prices[i]

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);// 今天买入股票时，要在昨天的利润基础上进行买入
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        // 测试
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
