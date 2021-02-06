package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 15:51
 */
public class MatrixReshape_566 {

    int[][] nums = { {1,2}, {3,4}};
    int r = 2;
    int c = 4;

    @Test
    public void matrixReshape() {
        int m = nums.length, n = nums[0].length;
        // 特殊情况判断
        if (m * n != r * c) {
            System.out.println(nums);
            return;
        }
        // 双重循环 + 数组元素位置
        // 例：原5*7数组中的一个元素a[2][4]，要放在新的7*5数组的什么位置？？
        // a[2][4] = 2 * 7 + 4 = 18
        // 按行遍历的话
        // 所以他应该在新数组的中得位置：b[18 / 5]][18 % 5] = b[3][3] => 3*5+3=18

        int[][] resArr = new int[r][c];
        int count = 0;// 表示按行遍历时，在数组中的第几个位置
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                resArr[i][j] = nums[count / n][count % n];
                count++;
            }
        }
        System.out.println(resArr);
    }
}
