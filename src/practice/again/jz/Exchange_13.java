package practice.again.jz;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/5/25 20:21
 */
public class Exchange_13 {

    public  static int[] reOrderArray (int[] array) {
        // write code here
        // 双指针解法
        // 左指针指向数组的初始位置，右指针指向数组的末尾位置
        // 如果左指针扫描到的数是偶数，或者如果右指针扫描到的数是奇数，交换两个指针所指向的数据，再将对应指针左移或者右移
        int left = 0, right = array.length - 1;
        while(left < right) {
            // 找到左边第一个偶数
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            // 找到右边第一个奇数
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            // 交换，指针移动
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }

    public static void main(String[] args) {
        // 测试
        int[] nums = {2,4,6,5,7};
        System.out.println(Arrays.toString(reOrderArray(nums)));
    }
}
