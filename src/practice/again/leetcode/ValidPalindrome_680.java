package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/1 20:38
 */
public class ValidPalindrome_680 {

    String s = "aba";

    @Test
    public void validPalindrome() {
        // 双指针解法
        // 左右指针遍历字符串，
        // 如果遇到有两个指针所指的字符不祥的情况
        // 判断删除左指针所指字符之后是不是回文串
        // 或者判断删除右指针所指字符后是不是回文串
        // 若有任何一方都不是回文串，则该串就不是回文串

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                System.out.println(isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1));
                return;
            }
            left++;
            right--;
        }
        System.out.println(true);
    }

    // 编写一个函数，用于判断一个区间内的字符串是不是回文串
    public boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
