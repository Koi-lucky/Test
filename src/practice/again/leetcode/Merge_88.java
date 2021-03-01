package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/1 21:08
 */
public class Merge_88 {

    int[] nums1 = {1,2,3,0,0,0};
    int m = 3;
    int[] nums2 = {2,5,6};
    int n = 3;

    @Test
    public void merge() {
        // 双指针解法
        // 从两个数组的末尾进行遍历、互相比较（从num1的实际数组的位置进行比较）
        // 那个数组末尾的值大，就将它放在num1的末尾，对应指针前移

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
    }
}
