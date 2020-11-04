package niuke.jz;

import org.junit.Test;

import java.util.Stack;

public class IsPopOrder_21 {

    int[] pushA = {1,2,3,4,5};
    int[] popA = {4,5,3,2,1};

    @Test
    public void IsPopOrder() {
        // 在两个给定的队列不为空的情况下进行操作
        if (pushA != null && popA != null && popA.length == pushA.length) {
            int i = 0;// 入栈队列的指针
            int j = 0;// 出栈队列的指针
            Stack<Integer> stack = new Stack<>();
            while (j < popA.length) {
                // 如果栈为空 或者 栈顶的数据！= j 指向的数据
                while (stack.isEmpty() || stack.peek() != popA[j]) {
                    // 如果i指针的长度已经等于入栈队列的长度,直接结束循环
                    if (i == pushA.length) {
                        break;
                    }
                    stack.push(pushA[i]);// 将i指针指向的元素压入栈中
                    i++;// 入栈队列的指针 i 指针后移
                }
                // 如果栈顶元素 ！= j指向的元素，直接跳出循环
                if (stack.peek() != popA[j]) {
                    break;
                }
                stack.pop();// 如果栈顶元素 == j指向的元素， 直接弹出栈顶元素即可
                j++;// 出栈队列的指针 j 后移
            }
            // 如果数据栈此时已经为空，并且j 指针指向的元素已经是队列的最后一个元素，则这个队列就是合法的队列
            if (stack.isEmpty() && j == popA.length) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
