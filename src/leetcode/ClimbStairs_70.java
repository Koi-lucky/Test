package leetcode;

import org.junit.Test;

public class ClimbStairs_70 {

    int n = 3;

    /**
     * 方法一：递归（时间复杂度太高，会超出时间限制，【不推荐】）
     * 方法二：非递归
     */
    @Test
    public void climbStairs1() {
        if (n == 1 || n == 2) {
            System.out.println(n);
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        System.out.println(a[n]);
    }

}
