package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 17:42
 */
public class KthSmallest_378 {

    int[][] matrix = {{ 1,  5,  9},
            {10, 11, 13},
            {12, 13, 15}};
    int k = 8;

    @Test
    public void kthSmallest() {
        // 二分查找法
        // 不妨假设答案为 x，那么可以知道 l≤x≤r，这样就确定了二分查找的上下界。
        // 每次对于「猜测」的答案 mid，计算矩阵中有多少数不大于mid ：
        // 如果数量不少于 k，那么说明最终答案 x 不大于 mid；
        // 如果数量少于 k，那么说明最终答案 x 大于 mid。

        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];// 数组中的最大值就是数组的第一个元素，最小值即为数组的最后一个元素
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;// 用于统计小于mid的数量
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                    }
                }
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }
}
