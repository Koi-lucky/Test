package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/22 22:00
 */
public class AddToArrayForm_989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = A[i] + K % 10;
            K /= 10;
            if (sum >= 10) {
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; K > 0; K /= 10) {
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }
}
