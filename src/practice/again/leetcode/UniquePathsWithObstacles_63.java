package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/17 17:29
 */
public class UniquePathsWithObstacles_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 62题进阶 —— 带障碍的路径
        // 动态规划解法
        // 遇到障碍就保持原来的初始值0

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];// 创建dp数组，默认初始化为0
        // 初始化dp数组
        // 遇到障碍就停止(让他保持初始值0)，没有障碍就赋值为1
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                dp[0][j] = 1;
            }
        }
        // 动态规划递推式逻辑
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果遇到障碍，就跳过
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回二维数组的最后一个位置
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
