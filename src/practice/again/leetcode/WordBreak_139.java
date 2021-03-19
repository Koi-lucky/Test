package practice.again.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/19 20:22
 */
public class WordBreak_139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        // 动态规划算法 ———— 完全背包的应用
        // 此处：背包是字符串s，要装进背包的是wordDict数组中的数值（可以重复装入）。单词能否组成字符串也就是问，物品能不能把背包装满
        // 1. dp[i]的意义:表示的是当字符串的长度为i时，dp[i]为true；表示可以拆分为一个或者多个在字典中出现的单词
        // 2. 在一个区间[j,i](j <i)的子串str，如果确定dp[j]=true,并且该字串str出现在字典中，那么一定就有dp[i]=true;
        // 3.上述为什么是[j,i]范围 —— 只问能不能装满背包，不涉及组合数/排列数，所以先遍历背包，或者先遍历物品都是可以的，但是，此题【先遍历背包】方便，如果先遍历物品，就得预先找个容器存储子串
        // 4.【初始化】dp[i]的状态取决于dp[j]是否为true，如果dp[j]=false，那么后面的遍历都是false就没有了意义，所以 —— 初始化dp[0] = true(题中以说明非空字符串，所以dp[0]=true只是为了递推式的推导)
        // 4.1 其他非零的下标所对应的指针都初始化为false
        // 【先遍历背包最好】

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 动态规划的递推式逻辑
        // 此处先遍历背包
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                // 进行条件判断——如果集合中存在区间[j,i]的子串，并且dp[j]=true
                if (wordDict.contains(str) && dp[j] == true) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        // 测试
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }
}
