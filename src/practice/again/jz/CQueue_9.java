package practice.again.jz;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/30 21:43
 */
public class CQueue_9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 先判断栈2是否是空栈，是的话将栈1的元素逐个入栈2
        // 若不是空栈，直接弹出栈顶元素即可
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // 如果此时栈2为空，直接返回,防止空指针异常
        if (stack2.size() == 0) {
            return 0;
        }
        int val = stack2.peek();
        stack2.pop();
        return val;
    }
}
