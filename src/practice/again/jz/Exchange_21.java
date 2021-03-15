package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/15 20:21
 */
public class Exchange_21 {

    int[] nums = {1,2,3,4,5,6};

    @Test
    public void exchange() {
        // 双指针法解决
        // 左指针指向数组的初始位置，右指针指向数组的末尾位置
        // 如果左指针的数是偶数，将左指针的数 与右指针的数进行交换
        // 如果右指针的数是奇数，将左右指针的数进行交换

        if (nums.length == 0 || nums == null) {
            System.out.println(nums);
            return;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0){
                right--;
            }
            // 交换这两个数
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;

        }
       for (int val : nums) {
           System.out.print(val + "  ");
       }
    }
}
