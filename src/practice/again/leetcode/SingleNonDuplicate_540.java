package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/3 15:36
 */
public class SingleNonDuplicate_540 {

    int[] nums = {1,1,2,3,3,4,4,8,8};

    @Test
    public void singleNonDuplicate() {
        // 二分查找法
        // 奇数长度的数组首尾元素索引都为偶数，因此我们可以将 lo 和 hi 设置为数组首尾。
        // 我们需要确保 mid 是偶数，如果为奇数，则将其减 1。
        // 然后，我们检查 mid 的元素是否与其后面的索引相同。
        // 如果相同，则我们知道 mid 不是单个元素。且单个元素在 mid 之后。则我们将 lo 设置为 mid + 2。
        // 如果不是，则我们知道单个元素位于 mid，或者在 mid 之前。我们将 hi 设置为 mid。
        // 一旦 lo == hi，则当前搜索空间为 1 个元素，那么该元素为单个元素，我们将返回它。

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--; // 保证mid在偶数位
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        System.out.println(nums[left]);
    }
}
