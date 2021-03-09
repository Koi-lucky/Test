package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/9 19:34
 */
public class MaxSubArray_42 {

    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

    @Test
    public void maxSubArray() {
        // 动态规划

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);// 如果nums[i]是负数，就不用加了（也就是加0）
            res = Math.max(res, nums[i]);// 再从 max(nums[i], dp[i - 1] + nums[i])选最大值
        }
        System.out.println(res);
    }
}
