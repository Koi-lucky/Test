package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 18:22
 */
public class CoinChange_322 {

    public static int coinChange(int[] coins, int amount) {
        // 动态规划算法 ———— 完全背包的应用
        // 1.此处的背包容量大小是amount，要装入的物品是coins数组中的一个个数值（每个数可以重复装入）
        // 2.dp[j]的意义：表示的是要凑成金额j，所需要的最少的硬币个数为dp[j]
        // 3.因为题中只要求求最小的硬币个数 ———— 组合数/排列数都可以 ———— 也就是说，遍历的顺序可以是先背包，也可以先物品
        // 4.dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        // 5.数组的初始化：dp[0] = 0, 没有任何意义，只是为了方便递推式的逻辑。要求最小的个数，就将其所有非零的下表所对应数值都初始化为Integer.MAX_VALUE
        // 6.最终结果值的判断 —— 如果是Integer.MAX_VALUE，就返回-1

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 动态规划的递推式逻辑
        // 以下选择先物品，后背包（也可以先背包）
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 判断的数值dp[j - coins[i]] != Integer.MAX_VALUE,否则Integer.MAX_VALUE + 1 会上溢
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        // 最终结果值判断
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // 测试
        int[] coins = {1,3,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
