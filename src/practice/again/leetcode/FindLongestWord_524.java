package practice.again.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/2 20:41
 */
public class FindLongestWord_524 {

    String s = "abpcplea";
    List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");

    @Test
    public void findLongestWord() {
        String longestStr = " ";
        for (String str : dictionary) {
            int i = longestStr.length(), j = str.length();
            // 比较longestStr字符串的长度 与 str字符串长度
            // 如果longestStr长度已经大于str长度 ———— 直接跳过该str字符串，进入下一层循环，进行下一个str的判断
            // 如果longestStr的长度与str的长度相等了，并且longestStr的字典顺序 小于 str的字典顺序 ———— 表示longest在str的前面 ———— 直接跳过该str字符串，进入下一层循环，进行下一个str的判断
            if (i > j || (i == j && longestStr.compareTo(str) < 0)) {
                continue;
            }
            // 判断当前的str是不是s的子串，如果是，更新longestStr 的值
            if (isSubStr(s, str)) {
                longestStr = str;
            }
        }
        System.out.println(longestStr);
    }

    // 编写一个函数 ———— 判断字典中的每个字符串是不是s的字串
    public boolean isSubStr(String s, String target) {
        // 双指针解法
        // 一个指针i指向字符串s,一个指针j指向字符串target
        // 逐个比较两个字符串的字符，如果相等i、j指针都后移，
        // 如果不相等，i指针后移
        // 最终判断j指针的值是否就是target的长度，如果是则表明字符串target是字符串s的字串

        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
