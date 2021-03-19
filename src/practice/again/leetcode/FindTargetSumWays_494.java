package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 15:06
 */
public class FindTargetSumWays_494 {

    public static int findTargetSumWays(int[] nums, int S) {
        // 动态规划算法 ———— 01背包的应用
        // 1.表达式推导：设这个数组的和为sum，加法值为x，那么减法值就应该为sum-x；
        // 目标数s=x-(sum-x) => x = (s+sum)/2
        // 2.其中x就是target，也就是背包的容量
        // 【思路分析】
        // 1.dp[j]表示的是nums数组中和为j的方法一共有dp[j]种
        // 2.求共有多少种组合的递推式：dp[j] += dp[j - nums[i]]
        // 3.初始化dp[0]=1,其余非零下标的数值都初始化为0【可以认为，填满容量为0的背包只有1种方法，就是啥都不装】
        // 4.先物品再逆序背包

        int sum = 0;
        for (int val: nums) {
            sum += val;
        }
        if ((S + sum) % 2 != 0) return 0;// 如果和为奇数，则一定无解，因为没有两个数的和为奇数
        if (S > sum) return 0;// 如果所给的目标值 大于 整个数组的和，则一定无解
        int target = (S + sum) / 2;// 背包容量
        int[] dp = new int[target + 1];
        dp[0] = 1;// 初始化dp[0]=1，也就是说当背包容量为零时，只有一种方法，就是什么都不装
        // 动态规划的递推式逻辑
        for (int i = 0; i < nums.length; i++) {// 先遍历物品
            for (int j = target; j >= nums[i]; j--) {// 再倒序遍历背包——确保每一个物品只被放入一次
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1,1,1,1,1};
        int S = 3;
        System.out.println(findTargetSumWays(nums, S));
    }
}
