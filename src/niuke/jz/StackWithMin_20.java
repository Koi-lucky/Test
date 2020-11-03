package niuke.jz;

import java.util.Stack;

public class StackWithMin_20 {

    Stack<Integer> stack = new Stack<>();// 数据栈
    Stack<Integer> stack1 = new Stack<>();// 辅助栈

    // 将节点入栈
    public void push(int node) {
        stack.push(node);
        // 判断辅助栈是否为空 或者 判断node和辅助栈栈顶元素的大小关系
        if (stack1.size() == 0 || node < stack1.peek()) {
            // 更新辅助栈栈顶的值
            stack1.push(node);
        } else {
            // 将辅助栈栈顶元素值再次压入辅助栈
            stack1.push(stack1.peek());
        }
    }

    // 先判断栈是不是为空，再入栈
    public void pop(){
        assert (stack1.size() > 0 && stack.size() > 0);
        stack.pop();
        stack1.pop();
    }

    // 弹出栈顶元素
    public int top() {
        assert(stack.size() > 0 && stack1.size() > 0);
        return stack.peek();
    }

    // 找到栈中最小的元素
    public int min() {
        assert(stack.size() > 0 && stack1.size() > 0);
        return stack1.peek();
    }

    public static void main(String[] args){
        // 测试类
        StackWithMin_20 stack = new StackWithMin_20();

        stack.push(3);
        System.out.println(stack.min());
        System.out.println("==========");

        stack.push(4);
        System.out.println(stack.min());
        System.out.println("==========");

        stack.push(2);
        System.out.println(stack.min());
        System.out.println("==========");

        stack.push(3);
        System.out.println(stack.min());
        System.out.println("==========");

        stack.pop();
        System.out.println(stack.min());
        System.out.println("==========");

        stack.pop();
        System.out.println(stack.min());
        System.out.println("==========");

        stack.pop();
        System.out.println(stack.min());
        System.out.println("==========");


        stack.push(0);
        System.out.println(stack.min());
    }
}
