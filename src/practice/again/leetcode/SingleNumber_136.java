package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 20:06
 */
public class SingleNumber_136 {

    int[] nums = {2,2,1};

    @Test
    public void singleNumber() {
        // 异或操作
        // 对数组中的每个数进行异或操作，最终异或的结果值就是只出现一次的数字

        int res = 0;
        for (int val : nums) {
            res ^= val;
        }
        System.out.println(res);
    }
}
