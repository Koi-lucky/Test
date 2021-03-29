package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/29 19:53
 */
public class ReverseBits_190 {

    public static int reverseBits(int n) {
        // 1. 要检索整数 n 中最右边的位，可以应用模运算（即 n%2）或与运算（即 n &1）
        // 2. 为了组合反转位（例如 2^a，2^b）的结果，可以使用加法运算（即 2^a+2^b）或再次使用位或运算（即 2^a | 2^b）
        int res = 0;
        for (int i = 0; i < 32; i++ ) {
            res = res << 1;
            res = res | (n & 1);// 检索整数n中最右边的位，再进行组合反转
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        // 测试
        System.out.println(reverseBits(10));
    }
}
