package practice.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/21 16:49
 */
public class MyStack_225 {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack_225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    // 经过入队列的操作后，此时队列中队列头为出栈的元素，队列尾为栈顶元素
    public void push(int x) {
        queue.add(x);// 将所有元素加入到队列中去，此时队列尾的元素就应该是栈顶的元素
        int queueSize = queue.size();
        // 移出队列尾之前的那些元素，再把移出的那些元素重新入队列
        while (queueSize > 1) {
            queue.add(queue.remove());
            queueSize--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
