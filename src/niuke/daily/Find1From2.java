package niuke.daily;

import org.junit.Test;

import java.util.Arrays;

public class Find1From2 {

    int[] a = { 5, 6, 8, 8, 7, 3, 7, 5, 6};

    /**
     * 题目：一个数组，除一个元素外其它都是两两相等，求那个元素?
     * 思路分析：
     * 将数组中的每个数之间进行异或操作，0^0=0 ,0^a=a , a^a=0
     *
     */
    @Test
    public void find1From2() {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res ^= a[i];
        }
        System.out.println(res);
    }
}
