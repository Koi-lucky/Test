package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/24 21:02
 */
public class MaxProfit_4_188 {

    public static int maxProfit(int k, int[] prices) {
        // 动态规划算法
        // 买卖股票3的进阶版 —— 至多可以买卖K次
        // 依然是二维的dp数组，下面是找规律：
        // dp[i][j]中当j=0时，无任何操作；j=1时，第一次买入；j=2时，第一次卖出；j=3时，第二次买入；j=4时，第二次卖出。。。。
        // ◆ 找规律：除0以外，j为偶数就是卖出，j为奇数就是买入
        // 确定递推式：dp[i][1]有两种状态得出，分别是无操作时的状态（继续前一次的状态），以及买入的状态；dp[i][2]也有两种状态推出，分别是无操作时的状态（继续前一次的状态），以及卖出的状态
        // ◆ 找规律：当j为偶数时(j+2)，递推式可以写为：无操作时的状态dp[i-1][j+2]，以及卖出的状态dp[i-1][j+1] + prices[i]
        //           当j为奇数时(j+1)，递推式可以写为：无操作时的状态dp[i-1][j+1]，以及买入的状态dp[i-1][j] - prices[i]
        // 初始化：当j为奇数时，都初始化为-prices[0]；偶数时，都初始化为0

        // 特殊情况判断
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int j = 1; j < 2 * k; j += 2) {
            dp[0][j] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);// 奇数时买入
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);// 偶数时卖出
            }
        }
        return dp[prices.length - 1][2 * k];

    }

    public static void main(String[] args) {
        // 测试
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
}
