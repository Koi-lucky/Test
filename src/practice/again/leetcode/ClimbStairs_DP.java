package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 15:40
 */
public class ClimbStairs_DP {
    // 爬楼梯问题的终极难度 —— 动态规划
    // 一共有n阶台阶，可以跨1步，2步.....n步，求一共有多少种跨法

    public static int climbStairs(int n) {
        // 动态规划算法 —— 完全背包的应用
        // 1.dp数组的意义：dp[j]表示的是，容量为j的背包所能装入的物品的价值为dp[j] —— 也就是说：到达第j个台阶有dp[j]种方案
        // 2.在跳台阶时，比如3阶的台阶：“先跳一阶，再跳二阶”和“先跳二阶，再跳一阶”是完全不一样的！！也就是说：这实质是一个求排列数的问题
        // 3.【遍历顺序】求排列数：要求先遍历背包，再遍历物品。在此处，背包的容积为n，物品的价值也是n
        // 4.dp[j] += dp[j - i];
        // 5.初始化：dp[0]=1，表示跳第0个台阶，只有一种方法：就是不跳

        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 动态规划的递推式逻辑
        for (int i = 1; i <= n; i++) {// 先遍历背包
            for (int j = 1; j <= n; j++) {// 再遍历物品
                // 当背包的初始值从1开始时，加判断条件
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 测试
        int n = 5;
        System.out.println(climbStairs(n));
    }
}
