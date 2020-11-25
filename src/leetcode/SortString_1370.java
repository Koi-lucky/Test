package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/25 22:36
 */
public class SortString_1370 {

    String s = "aaaabbbbcccc";

    @Test
    public void sortString() {
        int[] num = new int[26];
        // 统计字符串中每个字符的个数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        // 用StringBuffer创建一个字符串对象，做字符串的拼接操作
        StringBuffer ret = new StringBuffer();
        // 字符串拼接的边界条件：结果字符串的长度必须要小于原字符串的长度
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        System.out.println(ret.toString());
    }
}
