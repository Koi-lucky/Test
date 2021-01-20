package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/20 22:15
 */
public class StrStr_28 {

    String haystack = "hello";
    String needle = "ll";

    @Test
    public void strStr() {
        // 特殊情况判断
        if (needle.length() == 0) {
            System.out.println(0);
            return;
        }
        char[] ch1 = haystack.toCharArray();
        char[] ch2 = needle.toCharArray();
        // 定义前缀表
        int[] next = new int[needle.length()];
        getNext(next, needle);
        // 利用前缀表来进行搜索查找
        int j = -1;// 因为前缀表里面定义的初始位置为-1
        for (int i = 0; i < ch1.length ; i++) {// 【注意i从0开始】
            // 前后缀不匹配
            while (j >= 0 && ch1[i] != ch2[j + 1]) {
                // 向前回溯
                j = next[j];
            }
            // 前后缀匹配
            if (ch1[i] == ch2[j + 1]) {
                j++;
            }
            // 文本串中出现了模块串
            if (j == (ch2.length - 1)) {
                System.out.println(i - j);
                return;
            }

        }
        System.out.println(-1);
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
