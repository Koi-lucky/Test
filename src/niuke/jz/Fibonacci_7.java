package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/7 16:58
 */
public class Fibonacci_7 {

    int n = 5;

    @Test
    public void Fibonacci() {
        // 出口条件
        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        // 将数计算过程中的中间数的值都存储起来，方便后面计算直接调用
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        System.out.println(arr[n]);
    }
}
