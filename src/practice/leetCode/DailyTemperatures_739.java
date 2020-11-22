package practice.leetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/22 21:12
 */
public class DailyTemperatures_739 {

    int[] T = {73, 74, 75, 71, 69, 72, 76, 73};

    @Test
    public void dailyTemperatures() {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];// 创建结果数组
        // 遍历给定的数组，
        for (int i = 0; i < T.length; i++) {
            // 如果栈为空 或者 栈顶的元素＞当前元素，则直接入栈（将当前元素的对应下标入栈）
            // 否则的话，用 当前元素的下标 与 栈顶元素的下标 进行做差，再将差值存入结果数组对应的位置中
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        // 输出结果数组
        for (int value : res) {
            System.out.print(value + " ");
        }
    }
}
