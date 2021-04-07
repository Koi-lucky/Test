package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/7 23:28
 */
public class Search_81_2 {

    public static boolean search(int[] nums, int target) {
        // 二分查找的应用 —— 如果遇到相同的数，就进行顺序查找（跳过）；如果左边子数组是一个递增的序列，并且target在左边的序列当中，在左边进行二分查找；如果右边是一个递增的数组序列，并且target在右边的序列当中，在右边的子数组中进行二分查找
        // 【总结】左右子树组分别进行二分查找

        // 特殊情况判断
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        // 二分查找的逻辑
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 如果遇到多个相等的值，跳过
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    // 如果target在左边递增的序列中
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    // 如果target在右边递增的序列中
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }
}
