package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/15 19:34
 */
public class SpiralOrder_54 {

    int[][] matrix = {{1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
    };

    @Test
    public void spiralOrder() {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int circle = (Math.min(m, n) + 1) / 2;// 定义圈数
        int i = 0;// 所进行的圈数
        // 从外部向内部进行逐层遍历
        while (i < circle) {
            // 从左至右
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            // 从上至下
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][(n - 1) - i]);
            }
            // 从右至左
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i) != i; j--) {
                // 【注意】边界条件：如果这一层只有一行的话，在第一个循环中已经进行打印了，这里就不需要再打印了，即：(m - 1 - i) != i
                list.add(matrix[(m - 1) - i][j]);
            }
            // 从下至上
            for (int j = (m - 1) - (i + 1) ; j >= i + 1 && (n - 1 - i) != i; j--) {
                // 【注意】边界条件：如果这一层只有一列的话，在第二个循环中已经进行打印了，这里就不需要再打印了，即：(n - 1 - i) != i
                list.add(matrix[j][i]);
            }
            // 每圈结束后，圈数+1
            i++;
        }
        System.out.println(list.toString());
    }
}
