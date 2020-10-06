package leetcode;

import org.junit.Test;

public class Tribonacci_1137 {

    int n = 4;

    @Test
    public void tribonacci() {
        int[] a = new int[n + 1];
        // 相当于是递归的出口条件
        a[0] = 0;
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }
        System.out.println(a[n]);
    }
}
