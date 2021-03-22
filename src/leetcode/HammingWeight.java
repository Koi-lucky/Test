package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/22 21:42
 */
public class HammingWeight {

    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        // 测试
        System.out.println(hammingWeight(10));
    }
}
