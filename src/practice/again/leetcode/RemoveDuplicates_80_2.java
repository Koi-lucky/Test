package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/6 20:53
 */
public class RemoveDuplicates_80_2 {

    public static int removeDuplicates(int[] nums) {
        // 双指针解法 —— 快慢指针
        // 让慢指针表示有效数列的长度，快指针进行搜索数组
        // 因为一个数要被允许出现两次，所以nums[fast]必须要和nums[low-2]进行比较，判断是不是相同
        // 数组的快慢指针必须从2开始，

        // 特殊情况
        if (nums.length < 2) {
            return nums.length;
        }
        int fast = 2, low = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[low - 2]) {
                nums[low] = nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
