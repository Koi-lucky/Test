package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/9 21:41
 */
public class MinSubArrayLen_209 {

    int s = 7;
    int[] nums = {2,3,1,2,4,3};

    @Test
    public void minSubArrayLen() {
        // 滑动窗口方法
        int res = Integer.MAX_VALUE;// 设置一个变量用于存储结果值
        int sum = 0;// 滑动窗口之和
        int i = 0;// 滑动窗口开始位置
        int subLength = 0;// 滑动窗口的长度
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 【解题重点】更新滑动窗口的初始位置i，以及更新滑动窗口的长度，并且判断是否符合条件
            while (sum >= s) {
                subLength = j - i + 1;// 更新滑动窗口的长度
                res = res > subLength ? subLength : res;
                // 更新sum值 并且 更新滑动窗口的初始位置
                sum -= nums[i];
                i++;
            }
        }
        // 如果res的值没有发生变化，则输出0 —— 说明没有符合条件的子序列
        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }
}
