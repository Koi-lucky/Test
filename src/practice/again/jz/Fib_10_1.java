package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/9 19:04
 */
public class Fib_10_1 {

    int n = 5;

    @Test
    public void fib() {
        // 特殊条件判断
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        // 创建一个数组，将中间出现的所有数值存储起来，方便后边的数据直接拿来使用
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        System.out.println(arr[n]);
    }
}
