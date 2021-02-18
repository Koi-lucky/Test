package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/18 20:39
 */
public class JudgeSquareSum_633 {

    int c = 5;

    @Test
    public void judgeSquareSum() {
        // 已知c >= 0
        // 双指针解法
        // 边界条件 【0,sqrt(c)】

        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left <= right) {
            int temp = left * left + right * right;
            if (temp < c) {
                left++;
            } else if (temp > c) {
                right--;
            } else {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
