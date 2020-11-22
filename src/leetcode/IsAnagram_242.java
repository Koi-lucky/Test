package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/22 17:00
 */
public class IsAnagram_242 {

    String s = "anagram";
    String t = "nagaram";

    @Test
    public void isAnagram() {
        // 字母异位词是指由相同的字母按照不同的顺序组成的单词，根据此含义，那么这两个单词的长度也一定相等

        // 特殊情况判断
        if (s.length() != t.length() || s == null || t == null) {
            System.out.println(false);
        }
        // 将字符串s的逐个字符存入哈希表中
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put( s.charAt(i), map.getOrDefault( s.charAt(i), 0) + 1);
        }
        // 遍历字符串t，如果在哈希表中找不着对应的键，就不是字母异位词
        for (int i = 0; i < t.length(); i++) {
            map.put( t.charAt(i), map.getOrDefault( t.charAt(i), 0) - 1);// 每找到一个对应的值就从map中减掉一个
            if (map.get(t.charAt(i)) < 0) {// 如果该键出现的次数 不等于 map中存储的值 ，
                System.out.println(false);
            }
        }
        System.out.println(true);
    }
}
