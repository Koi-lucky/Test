package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/18 21:44
 */
public class ReverseLeftWords_58_1 {

    String s = "abcdefg";
    int n = 2;

    @Test
    public void reverseLeftWords() {
        // 先进行两次区间反转
        // 再进行整体反转
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n - 1);
        reverse(sb, n, sb.length() - 1);
        reverse(sb, 0, sb.length() - 1);
        System.out.println(sb.toString());
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }
}
