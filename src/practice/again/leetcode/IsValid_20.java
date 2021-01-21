package practice.again.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/21 18:27
 */
public class IsValid_20 {

    String s = "([)]";

    @Test
    public void isValid() {
        // 扫描字符串，向栈中压入对应的括号 如果扫描到（，则向栈中压入），以此类推
        // 判断括号不匹配的情况
        // 1.左括号多出来了 —— 此时字符串已经扫描完毕了，但是栈中还有括号存在（即栈不为空）
        // 2.数量相同，但 左括号 配不上 右括号 ——　（｝
        // 3.右括号多出来了　——　此时字符串还没扫描完毕，但是栈已经空了
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0) {
            System.out.println(true);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.peek() != ch) {
                // 第2种 和 第3种情况
                System.out.println(false);
                return;
            } else {
                stack.pop();
            }
        }
        // 第1种情况
        System.out.println(stack.isEmpty());
    }
}
