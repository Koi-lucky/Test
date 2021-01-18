package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/18 20:01
 */
public class ReverseStr_541 {

    String s = "abcdefg";
    int k = 2;

    @Test
    public void reverseStr() {
        // 双指针法
        // left指向数组初始位置
        // right指向需要分情况讨论
        // 1.指向数组的末尾 ———— 如果剩余字符少于 k 个，则将剩余字符全部反转
        // 2.指向第i+k-1个数的位置 ———— 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样
        // 翻转操作
        // 将数组转为字符串输出

        char[] ch = s.toCharArray();
        // 遍历数组
        for (int i = 0; i < ch.length; i+= 2*k) {
            int left = i, right = Math.min( ch.length - 1,  i + k - 1);
            while (left < right) {
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
