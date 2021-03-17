package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/17 22:30
 */
public class NumTrees_96 {

    public static int numTrees(int n) {
        // 动态规划解法
        // 有n个结点，求能够成多少种二叉树？
        // 设此时第j个结点作为根节点，则他的左子树有j-1个（出去根节点），右子树有n-j个

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 测试
        int n = 5;
        System.out.println(numTrees(n));
    }
}
