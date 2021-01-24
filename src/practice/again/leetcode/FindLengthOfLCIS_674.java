package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/24 19:29
 */
public class FindLengthOfLCIS_674 {

    int[] nums = {1,3,5,4,7};

    @Test
    public void findLengthOfLCIS() {
        // 特殊情况判断
        if (nums.length == 0) {
            System.out.println(0);
            return;
        }
        int res = 1, count = 1;
        // 遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
                res = Math.max(count, res);
            } else {
                count = 1;
            }
        }
        System.out.println(res);
    }
}
