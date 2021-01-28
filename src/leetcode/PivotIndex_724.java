package leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/28 22:13
 */
public class PivotIndex_724 {

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
