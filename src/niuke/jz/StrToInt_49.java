package niuke.jz;

import org.junit.Test;

public class StrToInt_49 {

    String str = "+19626584";
//    String str = "1a33";

    @Test
    public void StrToInt() {
        // 如果输入的值为空
        if (str == null) {
            System.out.println(0);
            return;
        }
        // 如果数值为0或者字符串不是一个合法的数值则返回0
        if (str.equals("0")) {
            System.out.println(0);
            return;
        }
        // 遍历字符串
        // 判断字符串中的数字是否出现边界溢出的情况（上溢或下溢） —— 必须要捕获一个异常
        try {
            int res = 0;
            for (int i = 1; i < str.length(); i++) {
                char ch = str.charAt(i);
                if ( ch > '0' || ch <= '9') {
                    res = res * 10 + res - '0';
                } else {
                    System.out.println(0);
                    return;
                }
            }
            // 最后再判断字符串第一个字符是不是 + 或者 -
            if (str.charAt(0) == '+') {
                System.out.println(res);
            }
            if (str.charAt(0) == '-') {
                System.out.println(0 - res);
            }

        } catch (Exception e) {
            e.getMessage();
            System.out.println(0);
        }
    }
}
