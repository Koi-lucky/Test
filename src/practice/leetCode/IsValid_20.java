package practice.leetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/22 19:07
 */
public class IsValid_20 {

    String s = "([)]";

    @Test
    public void isValid() {
        Stack<Character> stack = new Stack<>();
        // 遍历字符串，拿出字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            // 如果字符是 左括号，就直接入栈
            if (temp == '(' || temp == '[' || temp == '{') {
                stack.push(temp);
            } else {// 如果字符是 右括号
                // 如果此时栈为空，则无法配对，直接返回false
                if (stack.isEmpty()) {
                    System.out.println(false);
                    return;
                }
                // 记录出栈的元素
                char value = stack.pop();
                // 判断 出栈的元素 和 字符串中的字符 是否匹配
                boolean b1 = temp == ')' && value != '(';
                boolean b2 = temp == ']' && value != '[';
                boolean b3 = temp == '}' && value != '{';
                if (b1 || b2 || b3) {// 如果有一个括号不匹配，直接返回
                    System.out.println(false);
                    return;
                }
            }
        }
        // 判断最终栈中是否为空，如果不为空就肯定有括号没有匹配到
        System.out.println(stack.isEmpty());
    }
}
