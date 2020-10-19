package leetcode;

import org.junit.Test;

public class BackspaceCompare_844 {

    String S = "ab#c";
    String T = "ad#c";

    /**
     * 思路分析：
     * 1.定义两个空的字符串，用于存放删除特殊字符后的字符串
     * 2.遍历两个字符串
     *      如果它是【退格符】，那么我们将栈顶弹出；
     *      如果它是【普通字符】，那么我们将其压入栈中。
     */
    @Test
    public void backspaceCompare() {
        System.out.println(judge(S).equals(judge(T)));
    }

    public String judge(String s) {
        // 定义一个空字符串，做栈的操作
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                // 如果它是【普通字符】，那么我们将其压入栈中。
                sb.append(ch);
            } else {
                // 如果它是【退格符】，那么我们将栈顶弹出；
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
}
