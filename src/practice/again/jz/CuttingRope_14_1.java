package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/31 17:15
 */
public class CuttingRope_14_1 {

    public static int cuttingRope(int n) {
        // 动态规划算法
        // 完全背包的应用
        int[] dp = new int[n + 1];
        dp[2] = 1;
        // 先背包后物品 —— 一件物品可以放入多次
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 测试
        int n = 10;
        System.out.println(cuttingRope(n));
    }
}
