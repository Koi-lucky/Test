package niuke.jz;

import org.junit.Test;

import java.util.Stack;

/**
 * 题目：用两个栈，实现队列的添加和删除操作
 * 思路分析：
 * 1.栈的特性：先进后出
 *   队列的特性：先进先出
 * 2.删除元素：①当栈2不为空时，栈2栈顶的元素即为最先进入的元素，弹出即可（因为先进入的元素在栈1最底部，弹出压入到栈2中后就会在栈2的栈顶，所以直接弹出栈2的栈顶即可）
 *             ②当栈2为空时，将栈1的所有元素逐个弹出，并压入到栈2中去
 * 3.插入元素：直接压入栈1即可
 */
public class TwoStacksComeOneQueue_5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        // 当栈2为空时，将栈1的所有元素逐个弹出，并压入到栈2中去
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.size() == 0) {
            throw new Exception("栈为空");
        }
        // 当栈2不为空时，栈2栈顶的元素即为最先进入的元素，弹出即可
        Integer val = stack2.peek();
        stack2.pop();
        return val;
    }

    public static void main(String[] args) throws Exception {
        TwoStacksComeOneQueue_5 twoStacks = new TwoStacksComeOneQueue_5();
        twoStacks.push(1);
        twoStacks.push(2);
        twoStacks.push(3);
        twoStacks.push(4);
        System.out.println(twoStacks.stack1);
        twoStacks.pop();
        twoStacks.pop();
        System.out.println(twoStacks.stack1);
    }
}
