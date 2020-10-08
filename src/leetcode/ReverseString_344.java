package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class ReverseString_344 {

    char[] s = {'h','e','l','l','o'};

    /**
     * 方法：双指针
     * 思路分析：
     * 1.定义两个指针，分别指向数组的头和尾
     * 2.遍历数组，交换头指针和尾指针的数值
     */
    @Test
    public void reverseString() {
        // 先判空
        if (s == null) {
            System.out.println(0);
        }
        // 1.定义两个指针，分别指向数组的头和尾
        int left = 0;
        int right = s.length - 1;
        // 2.遍历数组，交换头指针和尾指针的数值
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}
