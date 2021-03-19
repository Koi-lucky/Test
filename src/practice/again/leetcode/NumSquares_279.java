package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 19:51
 */
public class NumSquares_279 {

    public static int numSquares(int n) {
        // 动态规划算法 —— 完全背包的应用
        // 此处背包的容量是n,放入背包中的物品是n以内的完全平方数
        // 1.dp[j] 的意义：表示组成合为j的完全平方数的个数最少为dp[j]
        // 2.题中只要求最少个数 ———— 组合数/排列数均可 ———— 先遍历背包或者先遍历物品均可
        // 3.dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        // 4.数组的初始化：dp[0]=0,题中给出了和n是一个正整数，所以dp[0]只是为了递推式的推导
        // 4.1 求最小数，数组中所有非零下表所指向的数值都初始化为最大值Integer.MAX_VALUE


        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 动态规划递推式逻辑
        for (int i = 1; i * i <= n; i++) {// 先遍历物品
            for (int j = 1; j <= n; j++) {
                // 背包的容量从1开始，要做判断
                // 在dp[j - i * i] != Integer.MAX_VALUE的情况下进行判断，否则Integer.MAX_VALUE + 会出现上溢
                if (j - i * i >= 0 && dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 测试
        int n = 12;
        System.out.println(numSquares(n));
    }
}
