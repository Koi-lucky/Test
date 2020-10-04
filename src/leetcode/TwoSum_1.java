package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    int[] nums = { 2, 7, 11, 15};
    int target = 9;

    /**
     * 解法一：暴力穷举
     * 思路分析：
     * 1.创建一个空的数组用于存储两数的下标
     * 2.遍历数组
     *      2.1双层for循环
     *      2.2外层每次循环，第一个指针后移一位，对应第二个指针也会后移一位；内层循环则是判断该数与后面的数的和值
     *      2.3找到两个数的和为目标值target之后，记录两个数的下标，跳出循环
     * @return
     */
    @Test
    public void twoSum1() {
        // 1.创建一个数组用于存储俩数的下标
        int[] location = new int[2];
        //  2.遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            // 外层每次循环，第一个指针后移一位，对应第二个指针也会后移一位；内层循环则是判断该数与后面的数的和值
            for (int j = i + 1; j < nums.length; j++) {
                // 2.3找到两个数的和为目标值target之后，记录两个数的下标，跳出循环
                if (nums[i] + nums[j] == target) {
                    location[0] = i;
                    location[1] = j;
                    break;
                }
            }
        }
        System.out.println(location);
    }


    /**
     * 方法二：哈希表
     * 思路分析：
     * 1.创建一个双Integer的哈希表，对于数组中的每一个数num[i] ——> 去寻找有没有target-num[i]
     * 2.将找到的数插入到哈希表中——> 这样就确保他不会重复找到自己
     */
    @Test
    public void twoSum2() {
        // 1.创建一个双Integer的哈希表
        Map<Integer, Integer> map = new HashMap<>();
        // 2.遍历数组，查找有没有target-num[i]
        for (int i = 0; i < nums.length; i++) {
            //判断是不是target-num[i]
            if (map.containsKey(target - nums[i])) {
                // 找到了
                // 返回找到的两个数的下标
                System.out.println(new int[]{ map.get(target - nums[i]), i});
            }
            // 3.将找到的数插入到哈希表中——> 这样就确保他不会重复找到自己
            map.put( nums[i], i);
        }
        // 如果找遍数组都没找到就返回空数组
        System.out.println(new int[0]);
    }
}
