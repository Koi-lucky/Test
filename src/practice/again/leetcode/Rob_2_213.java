package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/20 15:39
 */
public class Rob_2_213 {

    public static int rob(int[] nums) {
        // 动态规划算法
        // 1.成环的“打家劫舍” —— 考虑要不要包含首尾元素
        // 1.1 考虑首尾元素都不包含
        // 1.2 考虑不包含尾元素，但是包含首元素
        // 1.3 考虑不包含首元素，但是包含尾元素
        // 1.4 【汇总】情况1.1被情况1.2和1.3包含了 —— 因为如果1.2和1.3都不考虑包含首尾元素的话，就是情况1.1
        // 2.把之前的“打家劫舍”的代码抽调出来

        if (nums.length == 1) {
            return nums[0];
        }
        int result1 = robRange(nums, 0, nums.length - 2);// 情况1.2
        int result2 = robRange(nums, 1, nums.length - 1);// 情况1.3
        return Math.max(result1, result2);

    }


    // 抽调出来的“打家劫舍”的代码
    public static int robRange(int[] nums, int start, int end) {
        // 特殊情况
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        // 动态规划的递推式逻辑
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
