package practice.again.jz;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/15 21:04
 */
public class MajorityElement_39 {

    public static int majorityElement(int[] nums) {

        /*
        // 解法一：
        // 将无序数组排序，数组最中间的值即为目标数
        Arrays.sort(nums);
        return nums[nums.length / 2];
        */

        // 解法二：
        // 摩尔投票法
        // 因为要从数组中找到 出现次数超过一半的数，所以 一定会有 目标数字的个数 > 其他数字的个数
        // 解题思路：
        // 可以将目标数字置为1，其他数字置为0
        // 当 目标数字出现的次数 正好等于 非目标数字出现的次数时，此时 目标数字与非目标数字相加的结果 为0
        // 按题意所述，最终的加和结果一定会 >0

        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int curSum = nums[0];// 当前和【每当 当前的和=0时，就缩小查找的范围，更新这个值】
        int votes = 0;// 求票数的加和
        for (int val : nums) {
            // 如果票数的和=0，更新当前的curSum
            if (votes == 0) {
                curSum = val;
            }
            // 如果是要找的目标数，就进行自增
            if (val == curSum) {
                votes++;
            } else {
                // 若是其他的数，就进行自减
                votes--;
            }
        }
        return curSum;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
