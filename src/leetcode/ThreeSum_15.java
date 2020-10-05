package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    int[] nums = { 1, 0, -1, 0, -2, 2};
    int target = 0;

    /**
     * 方法与 【第18题】四个数的解法一致
     * 思路分析：
     * 1.创建一个列表集合用于存储三个数的多种组合
     * 2.先判空，再排序
     * 3.两层循环
     *     第1层先确定第一个数
     *     3.1如果第一个数已确定，则如果有num[i]+num[i+1]+num[i+2]>target,则其他三个数不论怎么选都会大于target，退出此层循环
     *     3.2如果第一个数已确定，则如果有num[i]+num[n-1]+num[n-2]<target,则其他三个数不论怎么选都会小于target，此层循环结束，直接进入下一层
     *    第2层确定后两个数 ——> 【双指针】
     *     先求三个数的和
     *     3.3判断三个数的和是否等于target，
     *         如果相等，放入列表集合中，同时要保证相同的数不能重复使用
     *         如果大于，则右指针左移
     *         如果小于，则左指针右移
     */
    @Test
    public void threeSum() {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            System.out.println(list);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(list);
    }

}
