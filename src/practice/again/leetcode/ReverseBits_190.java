package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 20:49
 */
public class ReverseBits_190 {

    int n = 43261596;// 00000010100101000001111010011100

    @Test
    public void reverseBits() {
        // 1. 要检索整数 n 中最右边的位，可以应用模运算（即 n%2）或与运算（即 n &1）
        // 2. 为了组合反转位（例如 2^a，2^b）的结果，可以使用加法运算（即 2^a+2^b）或再次使用位或运算（即 2^a | 2^b）
        int res = 0;
        for (int i = 0; i < 32; i++ ) {
            res = res << 1;
            res = res | (n & 1);// 检索整数n中最右边的位，再进行组合反转
            n = n >>> 1;
        }
        System.out.println(Integer.toBinaryString(res));
    }
}
