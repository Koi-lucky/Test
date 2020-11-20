package practice.leetCode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/20 16:27
 *
 *
 * 题目：
 *      给定一个  haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
 *  出现的第一个位置 (从 0 开始)。如果不存在，则返回  -1。
 *
 *  思路：
 *      核心判断给定的字符串havstack，判断以当前字符开始的字符串是否等于目标字符串needle
 */
public class StrStr_28 {

    String haystack = "abcdefg";
    String needle = "ef";

    @Test
    public void strStr() {
        // 特殊情况判断
        if (needle.length() == 0) {
            System.out.println(0);
            return;
        }
        // 遍历给定的字符串，先找目标字符串的首字符
        int j;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {// 循环时，i的边界值不需要到length-1
            // 遍历目标字符串，从给定的字符串中 指定位置的字符串 与 目标字符串进行匹配
            for (j = 0; j < needle.length(); j++) {
                // 如果两个字符不相等，则直接跳出循环
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // 判断两字符串的长度是否相等，若相等则返回对应的字符串的下标值
            if (needle.length() == j) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
