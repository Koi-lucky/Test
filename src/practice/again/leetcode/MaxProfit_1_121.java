package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/24 14:06
 */
public class MaxProfit_1_121 {

    public static int maxProfit(int[] prices) {
        // 1.贪心算法
        // 左边取最小的值，右边取最大的值，那么差值就是最大利润
        /*
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);// 取左边最小的价格
            result = Math.max(result, prices[i] - low);// 取最大区间利润
        }
        return result;
        */


        // 2.动态规划算法
        // (1) dp数组的意义：dp[i][0]表示的是第i天【持有】股票的所得现金，开始是0，如果买入股票后就是一个负数
        // dp[i][1]表示的是第i天【不持有】股票的现金
        // (2) 递推式：dp[i][0]有两个方面得到：一个是不买入，也就是保持昨天的dp[i - 1][0];另一个是第i天买入股票了-prices[i]
        // dp[i][1]也有两个方面得到：一个是今天不持有，也就是保持昨天不持有股票的dp[i - 1][1];另一个是第i天卖出去了，他持有的利润就是dp[i - 1][0] + prices[i];
        // (3) 初始化：dp[0][0]=-prices[0]; dp[0][1]=0;
        // (4) 遍历的顺序：从前往后

        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        // 测试
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
