package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/8 21:09
 */
public class FindMin_153 {

    public static int findMin(int[] nums) {
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
        return nums[right];
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }
}
