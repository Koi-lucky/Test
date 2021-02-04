package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/4 20:37
 */
public class FindMaxAverage_643 {

    int[] nums = {1,12,-5,-6,50,3};
    int k = 4;

    @Test
    public void findMaxAverage() {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(1.0 * maxSum / k);
    }
}
