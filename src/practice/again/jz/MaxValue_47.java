package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/31 16:47
 */
public class MaxValue_47 {

    public static int maxValue(int[][] grid) {
        // 动态规划算法
        int m = grid.length, n = grid[0].length;
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // 测试
        int[][] grid = {{1,3,1},
        {1,5,1},
        {4,2,1}};
        System.out.println(maxValue(grid));
    }
}
