package practice.leetCode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/20 20:51
 */
public class Merge_88 {

    int[] nums1 = {1,2,3,0,0,0};
    int m = 3;
    int[] nums2 = {2,5,6};
    int n = 3;

    @Test
    public void merge() {
        // 特殊情况判断
        if (nums1.length <= 0 || m <= 0) {
            System.out.println(0);
        }
        if (nums2.length <= 0 || n <= 0) {
            System.out.println(nums1);
        }
        // 双指针 —— 从两个数组的有效值的最后一个数开始比较

        int index1 = m - 1;// 指向大数组有效值的最后一个数
        int index2 = n - 1;// 只想小数组的末尾
        int index = m + n - 1;// 用于从大数组的末尾开始放数
        while (index2 >= 0 || index1 >= 0) {
            if (index1 < 0) {
                nums1[index--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[index--] = nums1[index1--];
            }else if (nums2[index2] > nums1[index1]) {
                nums1[index--] = nums2[index2--];
            } else {
                nums1[index--] = nums1[index1--];
            }
        }
        for (int value : nums1) {
            System.out.print(value + " ");
        }
    }
}
