package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/17 15:55
 */
public class UniquePaths_62 {

    public static int uniquePaths(int m, int n) {
        // 动态规划解题
        int[][] dp = new int[m][n];// 定义二维dp数组，表示从(0,0)位置到(i,j)位置一共有dp[i][j]条路径
        // dp数组的初始化
        // 向下只有一条路，向右也只有一条路
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 动态规划递推式的逻辑
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回的是二维数组的最后一个位置，即dp[m-1][n-1]
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // 测试
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
