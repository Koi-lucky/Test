package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/12 21:09
 */
public class CanConstruct_383 {

    String ransomNote = "aa";
    String magazine = "aab";

    @Test
    public void canConstruct() {
        // 此处用数组解决 —— 不用map，因为map的空间消耗要 大于 数组的空间消耗
        int[] records = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            records[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            records[ransomNote.charAt(i) - 'a']--;

            if (records[ransomNote.charAt(i) - 'a'] < 0) {
                System.out.println(false);
                break;
            }
        }
        System.out.println(true);
    }
}
