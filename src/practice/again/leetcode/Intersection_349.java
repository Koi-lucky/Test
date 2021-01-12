package practice.again.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/12 20:03
 */
public class Intersection_349 {

    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};

    @Test
    public void intersection() {
        // 因为输出的值必须唯一，所以两数组先用set过滤一次
        // 遍历过滤后的第一个数组，在第二个数组中进行判断
        // 在第二个数组中的话，就把他加入到新的数组中
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (Integer val : set1) {
            if (set2.contains(val)) {
                intersectionSet.add(val);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        for (int res : intersection) {
            System.out.println(res);
        }
    }
}
