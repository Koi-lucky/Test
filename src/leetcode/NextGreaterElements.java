package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/6 15:57
 */
public class NextGreaterElements {

    int[] nums = {1,2,1};

    @Test
    public void nextGreaterElements() {
        // 单调栈解法
        // 构造单调递减的栈 —— 单调递减的序列的下一个更大元素是同一个数，不需要重复遍历
        // 将数组下标入栈；用下标取模就是循环数组

        // 构造结果数组
        int[] res = new int[nums.length];
        // 将数组填充满-1
        Arrays.fill(res,-1);
        // 构造单调栈
        Deque<Integer> que = new LinkedList<>();
        // 将数组拉直，遍历数组，将元素的下标入栈进行判断
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            // 如果栈为空，直接将元素入栈
            // 如果不为空，进行判断 ——
            // 如果当前元素>栈顶元素，就将栈中元素弹出，直到遇到当前元素<栈顶元素；
            // 如果当前元素<栈顶元素，就将当前元素入栈
            while (!que.isEmpty() && nums[que.peek()] < nums[i % nums.length]) {
                res[que.pop()] = nums[i % nums.length];
            }
            que.push(i % nums.length);
        }
        System.out.println(res);
    }
}
