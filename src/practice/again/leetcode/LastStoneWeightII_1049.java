package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/18 20:30
 */
public class LastStoneWeightII_1049 {

    public static int lastStoneWeightII(int[] stones) {
        // 动态规划算法 ———— 01背包问题的应用
        // 1.dp[j]的意义：容量为j的背包，可容纳的最大价值为dp[j]
        // 背包的容量：就是数组中的数值stones[i]；最大价值：也是数组中的数值stones[i]
        // 2.要求最后剩下的一块石头，就是要两个相近的数进行碰撞，才会得到最小的数
        // 2.1 也就是要求整个stones数组的和sum，再拿sum/2作为target当作背包的最大容量进行判断【尽可能的将数组的和分为两个相似的数值，这两个数值进行碰撞才会有最小的数出来】
        // 2.2 dp数组的长度大小，也可以定义为target；并且石头的质量都是正整数，所以dp数组可以初始化为0
        // 3. 遍历的顺序逻辑：外层遍历“物品”（此处也就是数组中的数值stones[i]），内层倒序遍历背包的重量（此处也是stones[i]，倒序遍历是为了让每一个石头的重量只使用一次，不重复）
        // 4. 最终的结果值dp[target] 一定【小于等于】 sum - dp[target]， 所以：最终剩下的小石头的值一定是： sum - dp[target] - dp[target]

        // 特殊情况判断
        if (stones.length == 1) {
            return stones[0];
        }
        int sum = 0;
        for (int val : stones) {
            sum += val;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {// 遍历“物品”
            for (int j = target; j >= stones[i]; j--) {// 遍历“背包”，一定是倒序遍历
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }

    public static void main(String[] args) {
        // 测试
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(stones));
    }
}
