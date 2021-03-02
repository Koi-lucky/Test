package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/2 19:49
 */
public class NumMatrix {

    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix.length > 0) {
            sums = new int[matrix.length][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }
}