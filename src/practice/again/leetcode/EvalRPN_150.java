package practice.again.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/21 19:07
 */
public class EvalRPN_150 {

    String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

    @Test
    public void evalRPN() {
        // 栈实现 —— 逆波兰表达式
        // 遍历数组，将元素压入栈中
        // 如果当前压入的元素是 运算符时，弹出栈顶的两个元素进行计算，并将结果压入栈中

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (tokens[i].equals("+")) {
                    stack.push(num2 + num1);
                }
                if (tokens[i].equals("-")) {
                    stack.push(num2 - num1);
                }
                if (tokens[i].equals("*")) {
                    stack.push(num2 * num1);
                }
                if (tokens[i].equals("/")) {
                    stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        System.out.println(stack.peek());
    }
}
