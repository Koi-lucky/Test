package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/2 21:50
 */
public class SearchInsert_35 {

    int[] nums = {1,3,5,6};
    int target = 7;

    @Test
    public void searchInsert() {
        // 特殊情况判断
        if (nums == null) {
            return;
        }
        // 二分查找法
        int left = 0;
        int right = nums.length;
        int ans = nums.length;// 定义一个临时变量，用于存储结果值
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid] ) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
