package practice.again.jz;

import org.junit.Test;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 15:06
 */
public class SpiralOrder_29 {

    int[] result;
    int index = 0;// 结果数组的索引值
    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

    @Test
    public void spiralOrder() {
        // 特殊情况判断
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println(new int[0]);
            return;
        }
        int row = matrix.length, col = matrix[0].length;
        result = new int[row * col];
        // 循环的圈数判断
        int start = 0;
        while (col > start * 2 && row > start * 2) {
            printMatrixCircle(matrix, row, col, start);
            start++;
        }
        System.out.println(Arrays.toString(result));
    }

    // 编写一个函数 —— 打印矩阵的第几圈数字
    public void printMatrixCircle( int[][] matrix, int row, int col, int start) {
        // 定义终止列号、终止行号 —— 方便做循环的终止条件
        int endY = row - 1 - start, endX = col - 1 - start;
        // 从左至右开始打印 —— 第一步：什么情况下都必须有
        for (int i = start; i <= endX; i++) {
            result[index++] = matrix[start][i];
        }
        // 从上至下开始打印 —— 第二步：矩阵至少要有2行，才会进行第二步 —— 终止行号 > 起始行号
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                result[index++] = matrix[i][endX];
            }
        }
        // 从右至左开始打印 —— 第三步：矩阵至少要有2行2列，才会进行第三步 —— （终止行号 > 起始行号）&&（终止列号 > 起始列号）
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {// 注意边界条件：截止到圈数start的位置
                result[index++] = matrix[endY][i];
            }
        }
        // 从下至上开始打印 —— 第四步：矩阵至少要有3行2列，才会进行第四步 —— （终止行号 - 起始行号 > 1）&&（终止列号 > 起始列号）
        if (start < endX && endY - start > 1) {
            for (int i = endY - 1; i >= start + 1; i--) {// 注意边界条件：截止到圈数 + 1的位置
                result[index++] = matrix[i][start];
            }
        }
    }
}
