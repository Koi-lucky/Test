package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/18 19:54
 */
public class CanPartition_416 {

    public static boolean canPartition(int[] nums) {
        // 动态规划解法 ———— 01背包问题的应用
        // 1.构造的dp[]数组的意义：dp[j]表示可以凑成j的子集为dp[j]
        // 2.相当于背包中放入的物品是 数值 ，所以该“重量”为 nums[i]， “价值”也为nums[i]
        // 3.根据2就可以构造递推式
        // 4.遍历的顺序：先遍历“物品”（此题中是数值），再倒序遍历“背包质量”（此题中是sum/2）
        // 4.1 只要找到数组中为sum/2的和的子集，即代表该数组可以拆分为两个相等的子集
        // 4.2 在拆分时，如果sum的值是一个奇数，不可以拆分，就代表不能拆分。没有两个正整数的和是一个奇数
        // 5.判断最终的结果值：如果dp[target] == target，就代表找到了

        // 特殊情况
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[200*100 + 1];// 题中已知：每个数组中的元素不会超过100，数组的大小不会超过200，所以背包总和不会超过 200*100 = 20000，所以定义一个20000大的数组
        // 动态规划的递推式逻辑
        for (int i = 0; i < nums.length; i++) {// 遍历“物品”
            for (int j = target; j >= nums[i]; j--) {// 遍历“背包” —— 一定是倒序遍历，为了让每一个“物品”都只被放一次
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        // 最终对结果值进行判断
        if (dp[target] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
