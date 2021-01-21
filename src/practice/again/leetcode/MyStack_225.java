package practice.again.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/21 18:10
 */
public class MyStack_225 {


    // 定义两个队列，来模拟栈的相关操作
    Queue<Integer> queue1 = null;// 存储真实数据队列
    Queue<Integer> queue2 = null;// 辅助队列


    /** Initialize your data structure here. */
    public MyStack_225() {
        // 初始化队列
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.add(x);
        // 先直接压入queue2中
        // 如果不为空，先将queue1的所有数据弹出，压入到queue2中去，
        // 再交换queue1和queue2的值
        // 把queue2作为新的queue1，此时压入的元素x在栈顶
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 如果queue1不为空， 弹出queue1顶部的数据
        return queue1.remove();
    }

    /** Get the top element. */
    public int top() {
        // 因为队列1是真实存储数据的队列，所以只需要输出queue1的栈顶元素
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        // 因为队列1是真实存储数据的队列，所以只需要判断queue1是否为空
        return queue1.isEmpty();
    }
}
