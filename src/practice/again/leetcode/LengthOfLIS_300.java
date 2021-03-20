package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/20 17:18
 */
public class LengthOfLIS_300 {

    public static int lengthOfLIS(int[] nums) {
        // 动态规划算法
        // 1.dp[i]：表示的是i之前的（包括i）的最长上升子序列的长度为dp[i]
        // 2.在[j,i]区间内（j是从0到i-1），dp[i]是j从0到i-1范围内各个位置上的最长上升子序列 + 1 的最大值
        // 2.1 dp[i] = max(dp[i], dp[j] + 1)
        // 3.初始化时，将所有的数值都初始化为1，因为不管取不取该数，它的序列长度至少是1
        // 4.dp[i]是dp[j]从0到i-1推出来的，所以他的遍历顺序是：从左至右

        // 特殊情况判断
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int result = 0;
        // 动态规划的递推式逻辑
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 必须是递增的子序列
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最大的递增长子序列长度
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
