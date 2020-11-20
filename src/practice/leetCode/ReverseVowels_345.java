package practice.leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/20 20:12
 */
public class ReverseVowels_345 {

    String s = "leetcode";

    @Test
    public void reverseVowels() {
        // 特殊情况判断
        if (s == null || s.equals("")) {
            System.out.println(s);
            return;
        }
        // 双指针解法

        // 先将字符串转为字符数组进行处理
        char[] ch = s.toCharArray();
        // 将元音字母存入集合中
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        // 定义双指针遍历字符数组
        int index1 = 0;
        int index2 = ch.length - 1;
        while (index1 <= index2) {
            if (list.contains(ch[index1]) && list.contains(ch[index2])) {
                char temp = ch[index1];
                ch[index1] = ch[index2];
                ch[index2] = temp;
                index1++;
                index2--;
            } else if (!list.contains(ch[index2])) {
                index2--;
            } else if (!list.contains(ch[index1])) {
                index1++;
            }
        }
        System.out.println(String.valueOf(ch));
    }
}
