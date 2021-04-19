package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/19 22:34
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        // 双指针法
        // 左指针从左向右扫描数组
        // 右指针指向数组的末尾，
        // 一旦有左指针指向的数 == val ，将左指针的数与右指针的数进行交换，左指针右移，右指针左移
        // 若右指针指向的数 == val ，将右指针左移
        // 最终左指针指向的数组索引，即为新数组的长度，
        // 右指针指向的是待删除数组的第一个数据
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
