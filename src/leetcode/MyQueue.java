package leetcode;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/5 23:03
 */
public class MyQueue {

    // 定义两个栈来实现队列的相关操作
    Stack<Integer> pushStack = null;
    Stack<Integer> popStack = null;

    /** Initialize your data structure here. */
    public MyQueue() {
        // 初始化两个栈
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 向队列中添加元素，就是直接在pushStack中添加元素
        try {
            pushStack.push(x);
        } catch (Exception e) {
            System.out.println("栈已满，无法继续压入！");
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 从队列中弹出元素 —— 必须将输入栈中的元素挨个弹出，压栈至输出栈中，再逐个弹出（若输出栈不为空，先弹出，待其为空之后再进行重新压栈）
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();

    }

    /** Get the front element. */
    public int peek() {
        // 求 输出栈popStack 的栈顶元素
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // 队列为空 —— 则说明此时 pushStack和popStack 都为空
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
