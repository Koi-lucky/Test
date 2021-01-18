package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/18 20:35
 */
public class ReverseWords_151 {

    String s = "  Bob    Loves  Alice   ";

    @Test
    public void reverseWords() {
        // 将旧字符串去除掉多余的空格后转为新的字符串
        // 先反转整个字符串 —— 此时字符串中的单词也是反的
        // 再将单词进行第二次反转 —— 进行区间反转

        StringBuilder sb = deleteSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        System.out.println(sb);
    }

    // 去除多余的空格
    public StringBuilder deleteSpaces(String ss) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = ss.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && ss.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && ss.charAt(right) == ' ') {
            --right;
        }

        while (left <= right) {
            if (ss.charAt(left) != ' ') {
                sb.append(ss.charAt(left));
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(ss.charAt(left));
            }
            left++;
        }
        return sb;
    }
    // 区间反转
    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }
    // 反转每一个单词
    public void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 0;

        while (start < sb.length()) {
            // 循环至单词的末尾
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            end++;
        }
    }

}
