package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 20:18
 */
public class MissingNumber_268 {

    int[] nums = {3,6,1};

    @Test
    public void missingNumber() {
        // 对一个数进行两次完全相同的异或运算会得到原来的数

        int res = 0;
        for (int i = 0; i < nums.length ; i++) {
            res ^= i ^ nums[i];
        }
        System.out.println(res ^ nums.length);
    }
}
