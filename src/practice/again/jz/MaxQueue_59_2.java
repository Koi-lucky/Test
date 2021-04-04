package practice.again.jz;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/4 21:27
 */
public class MaxQueue_59_2 {

    Deque<Integer> deque;// 设置一个辅助队列，用于存储判断队列中的最大值
    Queue<Integer> queue;// 同于存放原数据的队列，保持原数据的输入输出逻辑

    public MaxQueue_59_2() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (deque.size() <= 0) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);

    }

    public int pop_front() {
        if (queue.size() <= 0) {
            return -1;
        }
        int res = queue.poll();
        if (res == deque.peekFirst()) {
            deque.pollFirst();
        }
        return res;
    }
}
