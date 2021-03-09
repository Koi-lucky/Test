package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/9 20:24
 */
public class NthUglyNumber_49 {

    int n = 10;

    @Test
    public void nthUglyNumber() {
        // 动态规划

        // 特殊情况判断
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        // 创建一个数组，存储中间产生的所有丑数，方便后续的数字直接拿来使用，不用重复进行计算
        int[] uglyNumber = new int[n];
        int a = 0, b = 0, c = 0;
        uglyNumber[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = uglyNumber[a] * 2, n3 = uglyNumber[b] * 3, n5 = uglyNumber[c] * 5;
            uglyNumber[i] = Math.min(Math.min(n2, n3), n5);// min(n2,n3,n5)中取最小值
            // 如果三个指针中有任何一个指针所指向的数等于uglyNumber[i]，就将指针后移 —— 去第一个大于n2或者n3或者n4的数
            if (uglyNumber[i] == n2) {
                a++;
            }
            if (uglyNumber[i] == n3) {
                b++;
            }
            if (uglyNumber[i] == n5) {
                c++;
            }
        }
        System.out.println(uglyNumber[n - 1]);
    }
}
