package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 20:29
 */
public class SingleNumber_260 {

    int[] nums = {1,2,1,3,2,5};

    @Test
    public void singleNumber() {
        // 先对所有数字进行一次异或，得到两个出现一次的数字的异或值
        // 在异或结果中找到任意为 1 的位
        // 根据这一位对所有的数字进行分组
        // 在每个组内进行异或操作，得到两个数字

        int tempRes = 0;
        for (int val : nums) {
            tempRes ^= val;
        }
        int div = 1;
        while ((div & tempRes) == 0) {
            div = div << 1;
        }
        int a = 0, b = 0;
        for (int val : nums) {
            if ((div & val) == 0) {
                a ^= val;
            } else {
                b ^= val;
            }
        }
        System.out.println(new int[]{a, b});
    }
}
