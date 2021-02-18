package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/18 20:18
 */
public class MinKBitFlips_995 {

    int[] A = {1,1,0};
    int K = 2;

    @Test
    public void minKBitFlips() {
        int n = A.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    System.out.println(-1);
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        System.out.println(ans);
    }
}
