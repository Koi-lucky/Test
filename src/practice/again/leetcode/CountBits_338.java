package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/3 16:02
 */
public class CountBits_338 {

    int num = 5;

    @Test
    public void countBits() {
        // 计算每一个数中1的个数
        // 通过位运算 n&(n-1) 就可以将最低位的1转为0 ———— 通过计算位运算操作的次数就可以得到数中1的个数

        int[] res = new int[num + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = countOnes(i);
        }
        System.out.println(res);
    }

    // 编写一个函数 —— 统计一个数中1的个数
    public int countOnes(int num) {
        int count = 0;// 计数器
        while (num > 0) {
            num &= (num - 1);
            count++;
        }
        return count;
    }
}
