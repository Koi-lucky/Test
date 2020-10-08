package leetcode;

import org.junit.Test;

public class ReverseStr_541 {

    String s = "abcdefg";
    int k = 2;

    /**
     * 方法：双指针
     * 思路分析：
     * 1.先将字符串转换为字符数组形式，方便用数组指针进行反转
     * 2.反转每2k个字符中的前k个字符 ——> 循环嵌套实现
     *  2.1 外层循环控制每2k个字符为一层循环，【循环的边界条件：i=i+2k】
     *      定义两个指针来操作翻转，左指针指向2k个字符的第一个位置，右指针则指向第k个位置
     *  2.2 内层的循环控制反转这2k个字符中的前k个字符，
     *      交换左右指针的数值
     */
    @Test
    public void reverseStr() {
        // 先判空
        if (s == null) {
            System.out.println(0);
        }
        //  1.先将字符串转换为字符数组形式，方便用数组指针进行反转
        char[] ch = s.toCharArray();
        //  2.反转每2k个字符中的前k个字符 ——> 循环嵌套实现
        //  2.1 外层循环控制每2k个字符为一层循环，【循环的边界条件：i=i+2k】
        for (int i = 0; i < ch.length; i += 2 * k) {
            //  定义两个指针来操作翻转，左指针指向2k个字符的第一个位置，右指针则指向第k个位置
            int left = i;
            int right = Math.min( left + k - 1, ch.length - 1);// 判断最后剩余的字符够不够2k或者够不够k
            //  2.2 内层的循环控制反转这2k个字符中的前k个字符
            while (left < right) {
                //  交换左右指针的数值
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(new String(ch));
    }
}
