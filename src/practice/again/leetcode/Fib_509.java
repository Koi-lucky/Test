package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/4 21:47
 */
public class Fib_509 {

    int N = 4;

    @Test
    public void fib() {
        // 特殊情况判断
        if (N == 0 || N == 1) {
            System.out.println(N);
            return;
        }
        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < N + 1; i ++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 100000007;
        }
        System.out.println(arr[N]);
    }
}
