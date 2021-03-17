package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/17 18:10
 */
public class IntegerBreak_343 {

    public static int integerBreak(int n) {
        // 动态规划算法
        // 计算一个数i的整数拆分dp[i]，一共有两种方法：
        // 从1开始遍历到j，（j的边界值[1,i-2],因为我们初始化的时候是从dp[2]开始的初始化，dp[1]和dp[0]没有意义）
        // 1.j * (i - j)
        // 2.j * dp[i - j]  ==>  将整数（i - j）进行拆分，（j是从1开始遍历的，不需要拆分）
        // 所以，dp[i]的取值在以上两种方法中取最大值


        int[] dp = new int[n + 1];
        dp[2] = 1;
        // 动态规划的递推逻辑
        // 初始化的是2，所以i就应该从3开始
        // j从1开始遍历，到i-2为止停止遍历
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 测试
        int n = 10;
        System.out.println(integerBreak(n));
    }
}
