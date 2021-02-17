package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 22:00
 */
public class GetSum_371 {

    public static int getSum(int a, int b) {
        // x ^ y（异或操作） —— 表示的是 “不考虑进位的情况下，两数的加和运算”
        // (x & y) << 1 —— 表示的是“进位”

        // 用递归实现两数的加和
        // 递归的出口条件是 —— (x & y) << 1 == 0
        // 因为每次 (x & y) << 1 操作，最右边都会多出一个0；一直递归，后面的0会不断增加，直到进位为0时，才会停止

        return b == 0 ? a : getSum( a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        // 测试两数相加
        int res = getSum(-2,3);
        System.out.println(res);
    }
}
