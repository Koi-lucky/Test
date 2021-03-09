package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/9 19:04
 */
public class Fib_10_2 {

    int n = 7;

    @Test
    public void numWays() {
        // 特殊条件判断
        if (n == 0) {
            System.out.println(1);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        // 创建一个数组，存储中间过程的所有数据，方便后面的数直接拿来取用，不用再进行重复计算
        int[] drop = new int[n + 1];
        drop[0] = 1;
        drop[1] = 1;
        for (int i = 2; i <= n; i++) {
            drop[i] = (drop[i - 1] + drop[i - 2]) % 1000000007;
        }
        System.out.println(drop[n]);
    }
}
