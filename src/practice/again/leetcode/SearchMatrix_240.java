package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 16:37
 */
public class SearchMatrix_240 {

    int[][] matrix = {{1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}};
    int target = 5;

    @Test
    public void searchMatrix() {
        // 特殊情况判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println(false);
            return;
        }
        // 分区域搜索目标数
        // 该行哪些数 > target ，舍掉后面所有的列 ———— 缩小搜索的范围
        // 该列哪些数 > target , 舍掉后面所有的行 ———— 缩小搜索的范围
        // 遍历所剩的区域，如果找到target就返回true，没找到就返回false

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                System.out.println(true);
                return;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println(false);
    }
}
