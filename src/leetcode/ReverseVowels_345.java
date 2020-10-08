package leetcode;

import org.junit.Test;

public class ReverseVowels_345 {

    String s = "leetcode";

    /**
     * 方法：双指针
     * 思路分析：
     * 1.先将字符串转为字符数组
     * 2.定义两个指针，左指针指向数组的头位置，右指针指向数组的末尾
     * 3.循环遍历数组，让左指针指向第一个元音字母，右指针指向最后一个元音字母，依次交换左右指针的字符
     *
     * 【元音字母】：A E I O U
     */
    @Test
    public void reverseVowels() {
        // 判空
        if (s == null) {
            System.out.println(0);
        }
        // 1.先将字符串转为字符数组
        char[] ch = s.toCharArray();
        // 2.定义两个指针，左指针指向数组的头位置，右指针指向数组的末尾
        int left = 0;
        int right = ch.length - 1;
        // 3.循环遍历数组，
        // 让左指针指向第一个元音字母，右指针指向最后一个元音字母，依次交换左右指针的字符
        while (left < right) {
            if(ch[left] == 'a' || ch[left] == 'e' || ch[left] == 'i' || ch[left] == 'o' || ch[left] == 'u' ||
                    ch[left] == 'A' || ch[left] == 'E' || ch[left] == 'I' || ch[left] == 'O' || ch[left] == 'U') {
                if (ch[right] == 'a' || ch[right] == 'e' || ch[right] == 'i' || ch[right] == 'o' || ch[right] == 'u' ||
                        ch[right] == 'A' || ch[right] == 'E' || ch[right] == 'I' || ch[right] == 'O' || ch[right] == 'U') {
                    char temp = ch[left];
                    ch[left] = ch[right];
                    ch[right] = temp;
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        System.out.println(new String(ch));
    }
}
