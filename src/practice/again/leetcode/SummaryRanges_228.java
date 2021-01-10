package practice.again.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/10 21:08
 */
public class SummaryRanges_228 {

    List<String> list = new ArrayList<>();
    int[] nums = {};

    @Test
    public void summaryRanges() {

        // 特殊情况判断
        // 如果数组为空
        if (nums.length <= 0) {
            System.out.println(list);
            return;
        }
        // 如果数组只有一个值
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            System.out.println(list);
            return;
        }
        // 双指针法遍历数组
        // 两指针left、right开始指向同一位置
        // [a,b]
        // left指针始终指向：每个区间范围的开始位置a
        // right指针始终指向的：每个区间的结束位置b
        // 判断右指针所指的值是不是左指针自增的值
        // 若是，将两个指针后移
        // 如此时不是，将left指针的值 + “ --> ” + right指针的值 加入list集合中
        // 更新left的指向位置 —— 指向right的位置
        // 更新right的指向位置 —— 右移一位
        // 再进行一轮判断

        int left = 0,right = 0;
        int val = nums[left];// 记录left指针的初始指向的值
        while (left < nums.length && right < nums.length) {

            // 如果是数组的最后一个数
            if (right == nums.length - 1) {
                if (val == nums[right]) {
                    list.add(nums[left] + "");
                } else {
                    list.add(val + "-->" + nums[right]);
                }
                break;
            }
            // 判断右指针所指的值是不是左指针自增的值
            if ((nums[left] + 1) == nums[right + 1]) {
                // 若是，将right指针后移,left指针也后移
                left++;
            } else {
                // 如此时不是，将left指针的值 + “ --> ” + （right指针的值 - 1） 加入list集合中
                // 如果左指针的值 == 右指针的值，只添加一个值
                if (val == nums[right]) {
                    list.add(val + "");
                } else {
                    list.add(val + "-->" + nums[right]);
                }
                left = right + 1;
                // 更新左指针的初始指向的值
                val = nums[left];
            }
            right++;
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
