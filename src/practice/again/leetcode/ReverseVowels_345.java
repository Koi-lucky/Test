package practice.again.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/18 20:51
 */
public class ReverseVowels_345 {

    String s = "hello";

    @Test
    public void reverseVowels() {
        // 已知元音字母：AEIOUaeiou
        // 双指针解法

        // 特殊情况
        if (s.length() <= 0 || s.equals(" ")) {
            System.out.println(" ");
            return;
        }
        char[] ch = s.toCharArray();// 将字符串转为字符数组进行操作
        int left = 0, right = ch.length - 1;
        // 将元音字母放入一个容器中，方便接下来的判断
        List<Character> list = Arrays.asList('A', 'E', 'I', 'O','U','a', 'e', 'i', 'o', 'u');
        while (left <= right) {

            if (list.contains(ch[left]) && list.contains(ch[right])) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                right--;
                left++;
            }else if (!list.contains(ch[left])) {
                left++;
            } else if (!list.contains(ch[right])) {
                right--;
            }
        }
        System.out.println(String.valueOf(ch));
    }
}
