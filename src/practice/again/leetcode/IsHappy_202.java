package practice.again.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/12 20:24
 */
public class IsHappy_202 {

    int n = 19;

    @Test
    public void isHappy() {
        // 计算每位上的值得平方和
        // 利用set判断会不会出现死循环
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
        }
        System.out.println(n == 1);
    }

    public int getSum(int m) {
        int sum = 0;
        while (m > 0) {
            int val = m % 10;
            sum += val * val;
            m /= 10;
        }
        return sum;
    }
}
