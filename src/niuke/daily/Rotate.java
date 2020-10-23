package niuke.daily;

import org.junit.Test;

public class Rotate {

    int[][] matrix = {
            { 1, 2, 3, 4},
            { 5, 6, 7, 8},
            { 9, 10, 11, 12},
            { 13, 14, 15, 16}
    };

    /**
     * 题目：将一个二维数组顺时针旋转90度（原地旋转）
     * 思路分析：双层for循环
     * 1.先将数组进行转置 —— 也就是沿主对角线对称位置上的元素进行交换
     * 2.再将数组进行 列上的 【逆序】 操作 —— 也就是将第i列元素 与 第n-1-i列元素 进行交换
     */
    @Test
    public void rotate() {
        // 1.先将数组进行转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2.再将数组进行 列上的 【逆序】 操作
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
        // 3.输出结果
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print( matrix[i][j] + "      ");
            }
            System.out.println();
        }
    }
}
