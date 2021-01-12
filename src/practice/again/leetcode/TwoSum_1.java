package practice.again.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/12 20:42
 */
public class TwoSum_1 {

    int[] nums = {2,7,11,15};
    int target = 9;

    @Test
    public void twoSum() {
        // 将数组的每个数存入map中
        // 遍历数组
        // 用当前遍历到的数被target减掉，再在map中找寻存不存在这样的数 —— 也就是在map中找有没有数 等于 target - nums[i]

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println(new int[]{map.get(target - nums[i]), i});
            }
            map.put(nums[i], i);
        }
        System.out.println(new int[0]);
    }
}
