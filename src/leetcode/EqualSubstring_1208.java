package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/5 19:34
 */
public class EqualSubstring_1208 {

    String s = "abcd";
    String t = "bcdf";
    int maxCost = 3;

    @Test
    public void equalSubstring() {
        // 双指针解法
        // 求出cost数组，用双指针法进行查询maxCost

        // 求cost数组
        int[] cost = new int[s.length()];
        for (int i = 0;i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        // 双指针法
        int left = 0, right = 0;
        int maxLength = 0;
        int sum = 0;
        while (right < s.length()) {
            sum += cost[right];
            while (sum > maxCost) {
                sum -= cost[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        System.out.println(maxLength);
    }
}
