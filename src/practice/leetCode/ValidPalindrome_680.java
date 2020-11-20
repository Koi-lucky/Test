package practice.leetCode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/20 20:40
 */
public class ValidPalindrome_680 {

    String s = "abca";

    @Test
    public void validPalindrome() {
        // 特殊情况判断
        if (s == null) {
            System.out.println(false);
            return;
        }
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1));
                return;
            }
        }
        System.out.println(true);
    }

    // 写一个函数 —— 用于判断从i到j位置这个长度的字符串是不是回文串
    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
