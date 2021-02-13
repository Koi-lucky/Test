package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/13 22:28
 */
public class FindDisappearedNumbers_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
