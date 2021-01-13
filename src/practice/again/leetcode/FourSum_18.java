package practice.again.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/13 21:49
 */
public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        // 确定第一个数
        for (int i = 0; i < length - 3; i++) {
            // 去重操作
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 连续四个数已经大于目标值，所以不用判断后面的了，因为数组是排序数组，后面的值要比当前的值更大
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            // 如果当前的值，与数组后三个数的和 小于 目标值，那么直接进入下一层循环 —— 也就是让 i++
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            // 确定第二个数
            for (int j = i + 1; j < length - 2; j++) {
                // 去重操作
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 退出循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 进入下一重循环
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                // 双指针法
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        // 去重
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        // 若四数之和 小于 target 左指针右移
                        left++;
                    } else {
                        // 若四数之和 大于 target 右指针左移
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
