package practice.again.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/12 19:43
 */
public class IsAnagram_242 {

    String s = "anagram";
    String t = "nagaram";

    @Test
    public void isAnagram() {
        // 如果两个单词字符串包含相同的字符及对应数量，只是字符顺序不同，则这两个单词就是有效的字母异位词

        // 定义一个数组，长度为26，数组下标表示该字母的位置，
        // 先遍历s,此时 —— 数组里面统计的是在字符串s中每个字符出现的次数
        // 再遍历t，每遍历到一个字符就在数组中减掉一个该字符
        // 最终判断数组是否为空，如果为空，则说明是有效的字母异位词；如果不为空，就说明不是有效的字母异位词

        int[] records = new int[26];
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            records[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < records.length; i++) {
            if (records[i] != 0) {
                System.out.println(false);
                break;
            }
        }
        System.out.println(true);
    }
}
