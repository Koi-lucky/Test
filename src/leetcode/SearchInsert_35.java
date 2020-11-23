package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/23 22:36
 */
public class SearchInsert_35 {

    int[] nums = {1,3,5,6};
    int target = 2;

    @Test
    public void searchInsert() {
        // 特殊情况判断
        if (nums == null) {
            System.out.println(-1);
        }
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;// 初始化ans为数组的长度，（如果target大于数组中所有的数，那就返回数组的长度）
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
