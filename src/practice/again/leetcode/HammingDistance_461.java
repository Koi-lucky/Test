package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 20:02
 */
public class HammingDistance_461 {

    int x = 1;
    int y = 4;

    @Test
    public void hammingDistance() {
        // 两个数先进行异或操作，得到一个结果值
        // 统计结果值中1的个数

        // 解法一：用计数器统计1的个数
        int count = 0, val = x ^ y;
        while (val != 0) {
            if ((val & 1) == 1) {
                count++;
            }
            val = val >> 1;
        }
        System.out.println(count);
        // 解法二：使用包装类的静态方法Integer.gitCount()来统计一个二进制数中1的个数
        // return Integer.bitCount(x ^ y);
    }
}
