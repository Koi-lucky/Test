package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/21 20:04
 */
public class SetZeroes {

    int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

    @Test
    public void setZeroes() {
        int m = matrix.length, n = matrix[0].length;
        // 设置一个标记位用于标记数组中为0的位置
        boolean[] rowFlag = new boolean[m];
        boolean[] colFlag = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = colFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowFlag[i] || colFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
