package practice.again.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/21 18:48
 */
public class RemoveDuplicates_1047 {

    String S = "abbaca";

    @Test
    public void removeDuplicates() {
        // 栈来解决
        // 遍历字符串
        // 判断是不是栈为空，栈为空可以直接压入
        // 判断栈顶元素 是不是 等于 即将要压入的元素，如果是，移动扫描字符串的指针，再删除栈顶元素
        // 最后将栈中剩余的元素逐个弹出，构成一个字符串
        // 此时还需要 反转字符串 才能进行返回

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
