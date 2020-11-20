package practice.leetCode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/20 19:37
 */
public class JudgeSquareSum_633 {

    int c = 5;

    @Test
    public void judgeSquareSum() {
        // 特殊情况
        if (c < 0) {
            System.out.println(false);
            return;
        }
        // 双指针解法
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            if (c == a * a + b * b) {
                System.out.println(true);
                return;
            } else if (c < a * a + b * b) {
                b--;
            } else {
                a++;
            }
        }
        System.out.println(false);
    }
}
