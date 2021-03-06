package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/6 16:16
 */
public class FindNumberIn2DArray_4 {

    int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };
    int target = 5;

    @Test
    public void findNumberIn2DArray() {
        // 不用双重for
        // 区域划分
        // 数组的每一行每一列都是递增的
        // 从数组第一行的末尾开始比较，如果当前值 > target，就删除当前值所在的列；如果当前值　＜ target，就接着搜索下一行

        //　特殊情况判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println(false);
            return;
        }
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r <= row - 1 && c >= 0) {
            if (matrix[r][c] == target) {
                System.out.println(true);
                return;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        System.out.println(false);
    }
}
