package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/3 14:55
 */
public class SearchRange_34 {

    int[] nums = {5,7,7,8,8,10};
    int target = 6;

    @Test
    public void searchRange() {
        // 二分查找法解决
        // 要找到target的初始位置、终止位置 就必须进行两次二分查找
        // 【最优解】我们将求解target的终止位置时，将其转换为求解target+1的初始位置 再将它向前移动一个位置， 就是target的终止位置 ———— 这样我们就可以只实现一次二分查找的代码即可

        int first = findFirst(nums,target);
        int last = findFirst(nums,target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            System.out.println(new int[]{-1, -1});
        } else {
            System.out.println(new int[]{first, last});
        }

    }

    // 编写一个函数 ———— 用于寻找数组中一个数的初始位置
    public int findFirst(int[] nums, int target) {
        // 二分查找法
        // 【注意】二分查找的边界是[0,nums.length] ———— 为什么右边界是nums.length？？因为要求target+1，如果我们是将一个数插入到数组的最后一个位置再往后一个位置时，要是右边界是nums.length-1，数组下标就会越界，所以右边界必须是nums.length

        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}
