package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/4 21:13
 */
public class MaxEnvelopes_354 {

    int[][] envelopes = {{1,1},{1,1},{1,1}};

    @Test
    public void maxEnvelopes() {
        if (envelopes.length == 0) {
            System.out.println(0);
            return;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        System.out.println(ans);
    }
}
