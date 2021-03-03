package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/3 14:33
 */
public class FindMin_153 {

    int[] nums = {3,4,5,1,2};

    @Test
    public void findMin() {
        // 二分查找法解决

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(nums[right]);
    }
}
