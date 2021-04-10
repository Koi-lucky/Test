package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/10 22:32
 */
public class IsUgly_263 {

    public static boolean isUgly(int n) {
        // 特殊情况考虑
        // 小于等于0的数都不是丑数
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        // 将该数不断地除以2、除以5、除以3，如果除到最后的结果为1，那他就是丑数，不为1他就不是丑数
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        // 测试
        int n = 14;
        System.out.println(isUgly(n));
    }
}
