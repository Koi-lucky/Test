package leetcode;

import org.junit.Test;

import java.util.HashSet;

public class Intersection_349 {

    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};

    @Test
    public void intersection() {
        // 1.先用set表过滤一下nums1
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> arr = new HashSet<>();// 用set存储两数组的交集
        for (int val : nums1) {
            set.add(val);
        }
        // 2.遍历nums2，
        for (int i = 0; i < nums2.length; i++) {
            // 2.1判断是否set表中包含相同的值，
            if (set.contains(nums2[i])) {
                // 2.2如果存在，则将相同的值放入新的数组中，
                arr.add(nums2[i]);
                // 2.3接着删掉set集合中的那个元素
                set.remove(nums2[i]);
            }
        }
        // 3.返回新的集合——即为两数组的交集
        for (int val : arr) {
            System.out.print(val + "   ");
        }
    }
}
