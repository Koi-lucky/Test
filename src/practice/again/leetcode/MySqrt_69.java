package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/2 21:22
 */
public class MySqrt_69 {

    int x = 8;

    @Test
    public void mySqrt() {
        // 二分查找算法

        // 特殊情况判断
        if (x <= 1) {
            System.out.println(x);
            return;
        }
        int i = 1, j = x;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int sqrt = x / mid;// 目标数应该满足sart=x/sqrt
            if (mid > sqrt) {
                j = mid - 1;;
            } else if (mid < sqrt) {
                i = mid + 1;
            } else {
                System.out.println(mid);
                return;
            }
        }
        // 退出while循环时，j是>i的，并且，j比i大1
        // 也就是说，当x=8时，退出循环时 —— j = 2, i = 3
        // 而 8 的平方根是 2.82842...
        // 所以返回的应该是 j ，而不是 i
        System.out.println(j);
    }
}
