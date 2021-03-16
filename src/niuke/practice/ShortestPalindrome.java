package niuke.practice;

import java.util.Scanner;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/16 23:10
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        // 边界值判断——判断字符串是否越界
        // 1.键盘键入一个字符串，并进行读取
        // 2.编写一个函数，找寻回文串的起始位置
        // 2.1 如果其实位置是0，则说明该串就是回文串，直接返回即可
        // 2.2 如果不是，从回文串的起始位置开始之前的字符，反向遍历拼接到该字符串的尾部


        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if (str.length() > Math.pow(10, 3)) {
            System.out.println(" ");
            return;
        }
        int index = palindromeStartPlace( str, 0);
        if (index == 0) {
            System.out.println(str);
        } else {
            System.out.println(concatenatedCharacters(str, index));
        }
    }

    // 编写一个函数 —— 用于判断回文串的起始位置
    public static int palindromeStartPlace(String s, int index) {
        if (index == s.length() - 1) {
            return s.length() - 1;
        }
        int i = index, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return j;
    }

    // 编写一个函数 —— 用于拼接字符
    public static String concatenatedCharacters(String s, int index) {
        StringBuffer sb = new StringBuffer(s);
        // 从index开始向前遍历，从index-1开始往字符串后面进行拼接
        for (int i = index - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
