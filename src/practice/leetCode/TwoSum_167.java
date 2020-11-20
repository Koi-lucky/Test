package practice.leetCode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/20 17:23
 */
public class TwoSum_167 {

    int[] numbers = {2, 7, 11, 15};
    int target = 9;

    /**
     * 解法一：双重循环 —— 效率低
     */
    @Test
    public void twoSum1() {
        // 特殊情况判断
        if (numbers.length <= 0) {
            System.out.println(new int[]{ 0, 0});
            return;
        }
        // 1.定义两个指针分别操作数组，左指针指向小的数组索引，右指针指向大的数组索引
        int index1;
        int index2;
        // 2.遍历数组
        for (index1 = 0; index1 < numbers.length - 1; index1++) {
            for (index2 = index1 + 1; index2 < numbers.length; index2++) {
                if (numbers[index2] == target - numbers[index1]) {
                    System.out.println(new int[]{ index1 + 1, index2 + 1});
                    return;
                }
            }
        }
        System.out.println(new int[]{ 0, 0});
    }


    /**
     * 解法二：双指针解法
     */
    @Test
    public void twoSum2() {
        // 特殊情况判断
        if (numbers.length <= 0) {
            System.out.println(new int[]{0, 0});
        }
        // 双指针解法
        // 1.定义两个指针分别操作数组，左指针指向数组的头位置，右指针指向数组的末尾位置
        int index1 = 0;
        int index2 = numbers.length - 1;
        // 2.遍历数组
        while (index1 < index2 && index2 < numbers.length) {
            if (numbers[index2] == target - numbers[index1]) {
                System.out.println(new int[]{index1 + 1, index2 + 1});
            } else if (numbers[index2] < target - numbers[index1]) {
                index1++;
            } else {
                index2++;
            }
        }
        System.out.println(new int[]{0, 0});
    }
}
