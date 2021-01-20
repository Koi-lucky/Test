package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/20 22:47
 */
public class RepeatedSubstringPattern_459 {

    String s = "abab";

    @Test
    public void repeatedSubstringPattern() {
        // 特殊情况判断
        if (s.length() == 0) {
            System.out.println(false);
            return;
        }
        char[] ch = s.toCharArray();
        int[] next = new int[s.length()];
        getNext( next, s);
        int len = ch.length;
        // 如果 next[len - 1] != -1，则说明字符串有最长相同的前后缀
        // 所以有最长相等前后缀的长度为：next[len - 1] + 1。
        // 如果 (数组长度-最长相等前后缀的长度) 正好可以被 数组的长度整除，说明有该字符串有重复的子字符串。
        if (next[len - 1] != -1 && len % (len - (next[len - 1] + 1)) == 0) {
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    // 创建前缀表 —— 也就是next[]
    // 创建两个指针 i 指向后缀终止位置-1的地方  j 指向前缀终止位置-1的位置
    public void getNext(int[] next, String s) {
        char[] ch = s.toCharArray();
        // 1.初始化
        int j = -1;
        next[0] = j;
        for (int i = 1; i < next.length; i++) {// 【注意i从1开始】
            // 2.处理前后缀不相同的情况
            // 因为要不断的向前面回溯寻找，所以此处是条件循环，而不是if条件判断
            while (j >= 0 && ch[i] != ch[j + 1]) {
                j = next[j];// 向前回溯
            }
            // 3.处理前后缀相同的情况
            if (ch[i] == ch[j + 1]) {
                // 就同时向后移动i 和j 说明找到了相同的前后缀
                j++;
            }
            // 4.更新前缀表的数值
            next[i] = j;// 将j（前缀的长度）赋给next[i]
        }

    }
}
