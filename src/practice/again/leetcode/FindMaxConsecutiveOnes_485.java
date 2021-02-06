package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 16:11
 */
public class FindMaxConsecutiveOnes_485 {

    int[] nums = {1,1,0,1,1,1};

    @Test
    public void findMaxConsecutiveOnes() {
        // 双指针解法
        // 左右指针初始值为数组的初始位置
        // 左指针和右指针分别指向的是数值为连续的1的序列的首部和尾部，并记录此时的1的个数
        // 遍历数组，求出连续的1个数的最大值

        int left = 0, right = 0;
        int count = 0;
        int res = count;
        while (right < nums.length) {
            if (nums[right] == 1) {
                count++;
                res = Math.max(res, count);
                right++;
            } else {
                left++;
                right++;
                count = 0;// 清零
            }
        }
        System.out.println(res);
    }
}
