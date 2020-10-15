package leetcode;

import org.junit.Test;

import java.util.*;

public class LongestCommonPrefix_14 {

    String[] strs = { "flower","flow","flight"};

    /**
     * 思路分析：
     * 1.
     */
    @Test
    public void longestCommonPrefix() {
        StringBuffer sb = new StringBuffer();
        int[] minAns = new int[52];// 大小写字母
        // 先给数组中充满最大数，方便之后的比较
        Arrays.fill( minAns, Integer.MAX_VALUE);
        for (int i = 0; i < strs.length; i++) {
            int[] ans = new int[52];
            for (int j = 0; j < strs[i].length(); j++) {
                // 统计每个个字符串中的字符出现的次数ans[],
                char ch = strs[i].charAt(j);
                ans[ch - 'a']++;
            }
            // 再让他和当前字符串中字符出现次数进行比较，取最小值minAns[]，不断地更新当前最小字符数组的值
            for (int k = 0; k < 52; k++) {
                minAns[k] = Math.min( minAns[k], ans[k]);
            }
        }

        // 将数组中的数转为对象的字符，输出到集合中
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < minAns[i]; j++) {
                sb.append((char)(i + 'a'));
            }
        }
        System.out.println(sb.toString());
    }
}
