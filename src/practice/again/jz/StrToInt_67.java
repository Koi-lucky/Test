package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/4 20:56
 */
public class StrToInt_67 {

    String str = "193 with words";

    @Test
    public void strToInt() {
        // 字符串转整数 需要注意的问题
        // 1.正负数问题 —— +和-
        // 2.存在空白字符
        // 3.首位不合法
        // 4.字符串转换过来的数字无法进行存储 —— 上溢或者下溢

        boolean isNegative = false;
        int i = 0;
        int j = 0;
        long res = 0;
        str = str.trim();
        if(str.length() == 0) {
            System.out.println(0);
            return;
        }
        //判断首位
        char[] ch = str.toCharArray();
        //首位有三种情况，+ - 或者数字
        if(ch[0] !='-' && ch[0] !='+' && !Character.isDigit(ch[0])) {
            System.out.println(0);
            return;
        }
        if(ch[0] == '-'){
            isNegative=true;
            i++;
        }else if(ch[0] == '+'){
            i++;
        }
        while(i<str.length() && Character.isDigit(ch[i])){
            res = res * 10+ ( ch[i++] - '0');
            if(res > Integer.MAX_VALUE) {
                System.out.println(isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE);
            }
        }
        System.out.println(isNegative ? -(int) res : (int)res);
    }
}
