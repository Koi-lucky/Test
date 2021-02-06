package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 15:28
 */
public class MoveZeroes_283 {

    int[] nums = {0,1,0,3,12};

    @Test
    public void moveZeroes() {
        // 特殊情况判断
        if (nums.length == 0) {
            return;
        }
        // 双指针解法
        // 左指针和右指针分别指向已处理序列的尾部、未处理序列的首部
        // 初始化让两个指针都指向数组的初始位置
        // 当右指针指向非0数时，将左右指针的数进行交换
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
