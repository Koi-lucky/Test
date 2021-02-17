package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 20:56
 */
public class IsPowerOfTwo_231 {

    int n = 218;

    @Test
    public void isPowerOfTwo() {
        //首先传进来的数肯定是要大于0的数
        //凡是2的幂，都满足这个条件——在二进制中，最高位为1，其余位为0，
        //判断他是不是2的幂——> 用 n 和 n - 1 进行按位与运算， 与运算的结果为 0 ，则是2的幂，否则就不是
        //  10000 & 01111 == 0 （0 & 1 等于 0）
        System.out.println(n > 0 && (n & (n - 1)) == 0);
    }
}
