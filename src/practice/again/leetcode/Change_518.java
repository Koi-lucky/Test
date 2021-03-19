package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 16:05
 */
public class Change_518 {

    public static int change(int amount, int[] coins) {
        // 动态规划算法 ————  完全背包的应用【每个物品可被放入多次】
        // 1. amount是背包的容量，coins是要装入放入物品，一个物品可悲重复装入多次
        // 2.dp[j]表示的是：容量为j的背包，可以凑成dp[j]个总金额的硬币组合数
        // 3. 所有的的求组合数的递推式：dp[j] += dp[j - coins[i]]
        // 4.【注意遍历顺序】如果是“先物品后背包” ———— 求的是组合数；如果是“先背包后物品” ———— 求的是排列数
        // 4.1 例如：如果是组合数，那么｛1,5｝、｛5,1｝这两个数列表示的意思一样，只用取其中一个即可
        //     如果是排列数，那｛1,5｝、｛5,1｝他两是不一样的，两种情况必须全部包含
        // 4.2 完全背包的内层背包容量的遍历 ———— 必须是正序的，因为他可以重复放入一个物品


        int[] dp = new int[amount + 1];
        dp[0] = 1;// 初始化dp[0]=1，表示容量为0的背包，只有一种情况，就是什么都不装入
        // 完全背包的递推式逻辑
        for (int i = 0; i < coins.length; i++) {// 先遍历物品
            for (int j = coins[i]; j <= amount; j++) {// 再正序遍历背包的容量 ———— 为的是重复放入一个物品
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        // 测试
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(amount, coins));
    }
}
