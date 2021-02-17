package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 21:23
 */
public class HasAlternatingBits_693 {

    int n = 7;

    @Test
    public void hasAlternatingBits() {
        // 异或操作
        // 凡是符合题目中的交替位二进制，那必然错位异或的话全是1，
        // 所以将错位异或的值+1后就会生成只有1个二进制1的值，
        // 再用n & (n-1) 进行检查消除一个二进制1后是否为0即可

        int val = (n ^ (n >> 1)) + 1;
        System.out.println((val & (val - 1)) == 0);

    }
}
