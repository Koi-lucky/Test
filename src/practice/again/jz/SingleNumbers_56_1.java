package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 21:46
 */
public class SingleNumbers_56_1 {

    int[] nums = {4,1,4,6};

    @Test
    public void singleNumbers() {
        // 异或操作
        // 1.先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        // 2.在异或结果中找到任意为 1 的位。
        // 3.根据这一位对所有的数字进行分组。
        // 4.在每个组内进行异或操作，得到两个数字。

        int ret = 0;
        // // 1.先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        for (int val : nums) {
            ret ^= val;
        }
        // 2.在异或结果中找到任意为 1 的位
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int val : nums) {
            // 3.根据这一位对所有的数字进行分组
            // 4.在每个组内进行异或操作，得到两个数字
            if ((val & div) != 0) {
                a ^= val;
            } else {
                b ^= val;
            }
        }
        System.out.println(new int[]{a, b});
    }
}
