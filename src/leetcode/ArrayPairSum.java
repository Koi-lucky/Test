package leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/16 23:57
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
