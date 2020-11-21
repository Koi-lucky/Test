package practice.leetCode;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/21 16:26
 */
public class MyQueue_232 {

    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    /** Initialize your data structure here. */
    public MyQueue_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 将栈1中的数据逐个弹出，再压入栈2中去，此时栈2中出栈的顺序符合先进先出原则
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
