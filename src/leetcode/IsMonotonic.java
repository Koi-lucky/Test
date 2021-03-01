package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/28 23:12
 */
public class IsMonotonic {

    int[] A = {6,5,4,4};

    @Test
    public void isMonotonic() {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        System.out.println(inc || dec);

    }
}
