package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/9 21:44
 */
public class GenerateMatrix_59 {

    int n = 3;
    int[][] res = new int[n][n];// 定义一个二维数组

    @Test
    public void generateMatrix() {
        int loop = n / 2;// 定义圈数，n=3的话，就是3/2=1圈，如果n是奇数，j矩阵则需要单独处理中间的那个值
        int startX = 0, startY = 0;// 定义每一圈开始时的坐标
        int mid = n / 2;// 定义矩阵的中间位置，如果n=3矩阵中间位置就是[1.1],如果n=5矩阵中间位置就是[2.2]
        int count = 1;// 填充每个空格
        int offset = 1;// 每一圈的循环，需要控制每一条边的遍历长度
        int i,j;
        while (loop > 0) {
            i = startX;
            j = startY;
            // 以下代码四个循环则 代表的是 模拟了一圈

            // 从左至右
            for (j = startX; j < startY + n - offset; j++) {
                // 开始时，i为【循环不变量】
                res[i][j] = count++;
            }
            // 上个循环的j作为下个循环的【循环不变量】
            // 从上至下
            for (i = startX; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }
            // 上个循环的i作为下个循环的【循环不变量】
            // 从右至左
            for ( ; j > startY; j --) {// 边界条件是j要大于开始的纵坐标，也就是startY
                res[i][j] = count++;
            }
            // 上个循环的j作为下个训话的【循环不变量】
            // 从下至上
            for ( ; i > startX; i--) {// 边界条件是i要大于开始的横坐标，也就是startX
                res[i][j] = count++;
            }

            // 每一圈结束后，更新下一圈的开始坐标
            startX++;
            startY++;
            // 每一圈结束后，更新offset的值
            offset += 2;
            // 每一圈结束后，更新圈数
            loop--;
        }

        // 如果n是奇数，更新矩阵中间的值
        if (n % 2 != 0) {
            res[mid][mid] = count;
        }
        for (int[] re : res) {
            for (int val : re) {
                System.out.print(val + "  ");
            }
            System.out.println();
        }
    }
}
