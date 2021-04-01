package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/1 22:04
 */
public class Clumsy {

    public static int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(N);
        N--;

        int index = 0; // 用于控制乘、除、加、减
        while (N > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * N);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / N);
            } else if (index % 4 == 2) {
                stack.push(N);
            } else {
                stack.push(-N);
            }
            index++;
            N--;
        }

        // 把栈中所有的数字依次弹出求和
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        // 测试
        int N = 10;
        System.out.println(clumsy(N));
    }
}
