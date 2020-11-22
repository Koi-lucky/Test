package practice.leetCode;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/22 18:34
 */
public class MinStack_155 {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack_155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 1.将元素挨个压入数据栈
        dataStack.push(x);
        // 2.如果辅助栈为空 或者 辅助栈的栈顶元素>即将要压入的这个值，直接将x压入栈中
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {// 否则的话，将辅助栈的栈顶元素再次入辅助栈（表示此时数据栈中的最小值 就是 辅助栈中的栈顶元素）
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        assert ( dataStack.size() > 0 && minStack.size() > 0);
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        assert ( dataStack.size() > 0 && minStack.size() > 0);
        return minStack.peek();
    }
}
