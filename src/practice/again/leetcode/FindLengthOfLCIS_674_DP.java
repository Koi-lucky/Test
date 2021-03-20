package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/20 17:29
 */
public class FindLengthOfLCIS_674_DP {

    public static int findLengthOfLCIS(int[] nums) {
        // 动态规划算法
        // dp[i]：表示的是到i为止的（包括i）的最大连续上升子序列为dp[i]
        // 因为判断的是连续递增的，所以就不需要j了，也就不用二维数组了，一维就可以解决
        // dp[i] = max(dp[i], dp[i - 1] + 1)
        // 初始化全为1
        // 遍历顺序从前往后

        // 特殊情况判断
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int result = 0;
        // 动态规划的递推式逻辑
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            if (dp[i + 1] > result) {
                result = dp[i + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {};
        System.out.println(findLengthOfLCIS(nums));
    }
}
