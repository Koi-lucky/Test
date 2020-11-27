package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/27 23:56
 */
public class FourSumCount_454 {

    int[] A = {1,2};
    int[] B = {-2,-1};
    int[] C = {-1,2};
    int[] D = {0,2};

    @Test
    public void fourSumCount() {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        System.out.println(ans);
    }
}
