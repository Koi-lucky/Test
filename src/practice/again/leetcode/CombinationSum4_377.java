package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 17:41
 */
public class CombinationSum4_377 {

    public static int combinationSum4(int[] nums, int target) {
        // 动态规划算法 ———— 完全背包的应用
        // 此处的背包容量为target，要放入的物品为nums数组（数组中的元素可重复放入）
        // 1.dp[j]的意义：表示的是总和为j的元素的组合的个数为dp[j]
        // 2.题中要求：｛1,3｝、｛3,1｝为不同的组合 ———— 所以这是一个求排列数的问题
        // 3.dp[j] += dp[j - nums[i]];
        // 4.初始化dp[0]=1:没有意义，只是为了推导式
        // 5.【遍历的顺序】排列数的遍历顺序 ———— 先背包，再物品

        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 动态规划的递推式逻辑
        for (int i = 0; i <= target; i++) {// 先遍历背包
            for (int j = 0; j < nums.length; j++) {// 再遍历物品
                // 背包的初始值从1开始，加判断条件
                // 【注意】这里的递推式，一定是 背包的容量 - 物品的重量
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }
}
