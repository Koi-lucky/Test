package practice.again.jz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 16:04
 */
public class TwoSum_57_1 {

    public static int[] twoSum(int[] nums, int target) {
        // 1.哈希表解决
        // 固定一个指针指向一个数num，在map中查找是否存在target-num的数，如果存在就输出
       /* Map<Integer, Integer> map = new HashMap<>();
        for (int val: nums) {
            map.put(val, map.getOrDefault(val, 0));
        }
        for (int val: nums) {
            if (map.containsKey(target - val)) {
                return new int[]{val,target - val};
            }
        }
        return new int[]{};*/
        // 2.已知是排序数组 —— 双指针法解决
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int res = nums[left] + nums[right];
            if (res == target) {
                return new int[]{nums[left], nums[right]};
            } else if (res < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {2,7,10,15,59};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
