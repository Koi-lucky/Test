package niuke.practice;

import java.util.Scanner;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/17 9:07
 */
public class JudgmentSubstring {

    public static void main(String[] args) {
        // 特殊条件判断 —— 两个字符串是否为空
        // 1.编写一个函数，判断一个字符串s串是不是另一个字符串t的子串
        // 1.1 双指针，一个指针left指向字符串s的初始位置，另一个指针right指向字符串t的初始位置
        // 1.2 如果s中含t的该字符，将两个指针都后移；否则的话，将right指针后移

        /*String s = "abc";
        String t = "ahbgdc";*/
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        if (s.length() <= 0 || s == null || t.length() < s.length()) {
            System.out.println(false);
            return;
        }
        System.out.println(isSubStr(s,t));
    }

    // 编写一个函数 —— 判断一个字符串是不是另一个字符串的子串
    public static boolean isSubStr(String s, String t) {
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        if (left == s.length()) {
            return true;
        }
        return false;
    }

}
