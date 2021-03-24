package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/24 18:16
 */
public class MaxProfit_3_123 {

    public static int maxProfit(int[] prices) {
        // 动态规划算法
        // 在“买卖股票1”的基础上，加了条件 —— 最多完成两次交易，也就是说dp数组有五种状态：dp[0]表示什么操作都没有,dp[1]表示第一次买入,dp[2]表示第一次卖出,dp[3]表示第二次买入,dp[4]表示第二次卖出
        // 递推式：dp[i][0]只有一个状态：前一天的没买入状态dp[i-1][0]
        // dp[i][1]有两个状态得到：一是【没有操作】，也就是前一天的状态dp[i][1],一个是在前一天的金钱数的基础上【准备买入】股票了dp[i-1][0] - prices[i]
        // dp[i][2]有两个状态得到：一是【没有操作】，也就是前一天的状态dp[i-1][2]，一是【卖出股票】了dp[i-1][1]+prices[i]
        // 同理可得，dp[i][3]和dp[i][4]也各有两种状态
        // dp[i][3]由 dp[i-1][3]和dp[i-1][2] - prices[i]得到
        // dp[i][4]由 dp[i-1][4]和dp[i-1][3] + prices[i]得到

        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

    public static void main(String[] args) {
        // 测试
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}
