package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/18 22:09
 */
public class LeftRotateString_43 {

    String str = "abcXYZdef";
    int n = 3;

    @Test
    public void LeftRotateString() {
        // 特殊情况判断
        if (str == null || n > str.length()) {
            return;
        }
        // 将字符串转为字符数组进行操作
        char[] ch = str.toCharArray();
        // 1.先将整个字符串进行反转
        resverString( ch, 0, str.length() - 1);
        // 2.以第n-1位为中间，将字符串分为两个字串，再将这两个子串分别进行反转，（三次反转之后的字符串就是目标串）
        resverString( ch, 0, str.length() - n - 1);
        resverString( ch, str.length() - n, str.length() - 1);
        // 输出
        System.out.println(String.valueOf(ch));
    }

    // 将一个指定索引的字符串进行反转
    public void resverString(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}
