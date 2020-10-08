package leetcode;

import org.junit.Test;

public class ReverseWords_557 {


    String s = "I love u";
    /**
     * 方法：双指针
     * 思路分析：
     * 1.先将字符串转为字符数组，以便进行后续的翻转操作
     * 2.定义左右指针来操作字符数组，左指针指向单词的第一个位置，有指针指向单词的最后一个位置
     * 3.循环遍历字符数组
     *  3.1让右指针找寻单词的最后一个位置
     *  3.2记录当前这个单词的尾指针，便于找寻下个单词的头指针
     *  3.3翻转当前这个单词的操作
     *  3.4更新左右指针的位置
     *      让左指针指向下一个单词的头位置，让右指针指向左指针的下一个位置
     */
    @Test
    public void reverseWords() {
        // 先判空
        if (s == null) {
            System.out.println(0);
        }
        // 1.先将字符串转为字符数组，以便进行后续的翻转操作
        char[] ch = s.toCharArray();
        int i = 0;// 定义循环的次数
        // 2.定义左右指针，左指针初始指向为0，右指针初始指向为为左指针的下一个位置
        int left = 0;
        int right = left + 1;
        // 3.循环遍历字符数组
        while (i < ch.length) {
            // 3.1让右指针找寻单词的最后一个位置
            while (right < ch.length - 1) {
                if (ch[right + 1] == ' ') {
                    break;
                }
                right++;
            }
            // 3.2记录当前这个单词的尾指针，便于找寻下个单词的头指针
            int j = right;
            // 3.3翻转当前这个单词的操作
            while (left < right && right < ch.length - 1) {
                if (ch[left + 1] == ' ') {// 如果是一个字母的话，直接跳过，不反转
                    left += 2;
                }
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
            // 3.4更新左右指针的位置
            left = j + 2;// 左指针指向下个单词的头指针
            right = left + 1;// 右指针指向左指针的下一个位置
            i++;// 进行下次循环
        }
        System.out.println(new String(ch));
    }

}
