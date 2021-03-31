package practice.again.jz;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/31 17:28
 */
public class CuttingRope_14_2 {

    public static int cuttingRope(int n) {
        // 动态规划算法
        // 完全背包的应用 + 大数取余

        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        // dp[1] = BigInteger.valueOf(1);
        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        // 测试
        int n = 10;
        System.out.println(cuttingRope(n));
    }
}
