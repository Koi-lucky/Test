package leetcode;

import org.junit.Test;

public class SmallerNumbersThanCurrent_1365 {

    int[] nums = { 8, 1, 2, 2, 3};

    @Test
    public void smallerNumbersThanCurrent() {
        // 定义一个空数组用于存储统计之后的数
        int[] arr = new int[nums.length];
        // 双重循环
        // 外层循环————取一个数，再取下一个数
        // 内层循环————让外层循环的数和数组中的每一个数去比较
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    arr[index] = ++count;
                }
            }
           index++;
        }
        for (int val : arr) {
            System.out.print(val + "  ");
        }
    }
}
