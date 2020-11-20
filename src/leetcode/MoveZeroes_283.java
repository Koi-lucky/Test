package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/19 20:20
 */
public class MoveZeroes_283 {

    int[] nums = {0,1,0,3,12};

    @Test
    public void moveZeroes() {
        // 特殊情况判断
        if (nums == null || nums.length <= 0) {
            return;
        }
        // 双指针解法
        // 定义左右指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
        // 最终的结果值：让左指针的左边都为非零数，右指针的左边至左指针的右边都为0 （也就是[left,right]的范围都为0）
        int left = 0;
        int right = 0;// 两指针初始值都指向同一个位置
        while (right < nums.length) {
            // 如果右指针指向的数据不为0，进行交换
            if (nums[right] != 0 ) {
                // 每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
        for (int value : nums) {
            System.out.print(value + " ");
        }
    }
}
