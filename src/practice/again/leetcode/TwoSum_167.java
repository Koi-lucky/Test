package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/18 20:31
 */
public class TwoSum_167 {

    int[] numbers = {2,3,4};
    int target = 6;

    @Test
    public void twoSum() {
        // 已知数组长度 >= 2;已知数组按递增排序；已知存在一个有效答案
        // 双指针解法

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp < target) {
                left++;
            } else if (temp > target){
                right--;
            } else {
                System.out.println(new int[]{left + 1, right + 1});
                return;
            }
        }
        System.out.println(" ");
    }
}
