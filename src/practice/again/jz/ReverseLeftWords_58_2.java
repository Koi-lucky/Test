package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 16:51
 */
public class ReverseLeftWords_58_2 {

    public static String reverseLeftWords(String s, int n) {
        // 先进行两次区间反转
        // 再进行整体反转
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n - 1);
        reverse(sb, n, sb.length() - 1);
        reverse(sb, 0, sb.length() - 1);
        return sb.toString();
    }

    public static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public static void main(String[] args) {
        // 测试
        String s = "abcdefg";
        int n = 2;
        System.out.println(reverseLeftWords(s,n));
    }
}
