package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/20 15:19
 */
public class Rob_1_198 {

    public static int rob(int[] nums) {
        // 动态规划算法
        // 1.dp[i]的意义：考虑的是下标i（包括i）的屋子最大可以偷窃的金额为dp[i]
        // 2.对于dp[i] —— 考虑“偷”还是“不偷” —— 如果偷，加上i的金额，再去偷下下一家（跳过下一家） —— 如果“不偷”，他的值就是上一次的值
        // 3.初始化，dp[0]=nums[0]. dp[1]=max(nums[0], nums[1])
        // 4.因为dp[i]是依赖于dp[i - 1] 和dp[i - 2]的， —— 所以是：从前往后遍历
        // 【注意】只是考虑！不是确定偷或者不偷

        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 动态规划的递推式逻辑
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
