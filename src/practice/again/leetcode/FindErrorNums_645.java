package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 18:05
 */
public class FindErrorNums_645 {

    int[] nums = {1,2,2,4};

    @Test
    public void findErrorNums() {
        // 先对数组进行排序，
        // 将排序后的数组进行遍历，判断是否nums[i] != i+1

        for (int i = 0;i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                exchange(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                System.out.println(new int[]{nums[i], i + 1});
                return;
            }
        }
        System.out.println(" ");
    }

    // 数组的排序 —— 通过交换数组元素，使数组元素在正确的位置上
    void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
