package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 21:14
 */
public class IsPowerOfFour_342 {

    int num = 5;

    @Test
    public void isPowerOfFour() {
        // 1.位操作
        // 首先得满足num>0
        // 其次得满足 是 2 的幂次方
        // 最后 还得区分 2 的偶数幂（当 xx 是 4 的幂时）和 2 的奇数幂（当 xx 不是 4 的幂时）。在二进制表示中，这两种情况都只有一位为 1，其余为 0。
        // 有什么区别？在第一种情况下（4 的幂），1 处于偶数位置：第 0 位、第 2 位、第 4 位等；在第二种情况下，1 处于奇数位置。
        // 因此 4 的幂与数字 (101010...10)_2向与会得到 0。即 4^a & (101010...10)_2 == 0
        // (101010...10)_2用十六进制表示为 ：(aaaaaaaa) 16
        System.out.println((num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0));
        // 2.正则表达式
        // return Integer.toString(num, 4).matches("^10*$");
    }
}
