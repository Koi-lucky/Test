package practice.again.jz;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/30 21:48
 */
public class MinStack_30 {


    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> helpStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (helpStack.isEmpty() || helpStack.peek() > node) {
            helpStack.push(node);
        } else {
            helpStack.push(helpStack.peek());
        }
    }

    public void pop() {
        if (dataStack.size() > 0) {
            dataStack.pop();
        }
        if (helpStack.size() > 0) {
            helpStack.pop();
        }
    }

    public int top() {
        if (dataStack.size() == 0) {
            return 0;
        }
        return dataStack.peek();
    }

    public int min() {
        if (helpStack.size() == 0) {
            return 0;
        }
        return helpStack.peek();
    }
}
