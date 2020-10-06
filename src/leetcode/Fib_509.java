package leetcode;

import org.junit.Test;

public class Fib_509 {

    int n = 2;

    /**
     * 方法一：递归（时间复杂度太高，会超出时间限制，【不推荐】）
     * 方法二：非递归
     */
    @Test
    public void fib() {
        if (n == 0 || n == 1) {
            System.out.println(n);
        }
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        System.out.println(a[n]);
    }
}
