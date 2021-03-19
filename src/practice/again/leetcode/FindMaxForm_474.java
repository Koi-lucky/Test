package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 15:28
 */
public class FindMaxForm_474 {

    public static int findMaxForm(String[] strs, int m, int n) {
        // 动态规划算法 ———— 01背包的应用【双重01背包】
        // 1.将m、n看作是两个要填充的背包，字符串数组就是要装入的物品，
        // 2.dp[i][j]表示的就是: i个0、j个1能构成的最大子集数为dp[i][j]
        // 3.dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)
        // 3.1 其中，zeroNum表示的是该物品中0的个数，oneNum表示的是该物品中1的个数
        // 4. 先遍历物品，再逆序遍历背包
        // 5.数组的初始化：无特殊情况下，01背包数组都初始化为0

        int[][] dp = new int[m + 1][ n + 1];
        for (String val : strs) {// 遍历物品
            int zeroNum = 0, oneNum = 0;
            for (int k = 0; k < val.length(); k++) {
                if (val.charAt(k) == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 倒序遍历背包
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        // 测试
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }
}
