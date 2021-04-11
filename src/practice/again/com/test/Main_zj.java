package practice.again.com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/11 20:26
 */
public class Main_zj {

    // 创建长度为26的字符数组，以及创建长度为10的整型数组
    static List<Character> charList = Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','R','S','T','U','V','W','X','Y','Z');
    static List<Character> intList = Arrays.asList('0','1','2','3','4','5','6','7','8','9');

    public static void main(String[] args) {
        // 输入测试用例
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            System.out.println(strToNewStr(input));
        }
        sc.close();
    }


    // 编写一个函数用于完成字符串破译的操作
    public static String strToNewStr(String s) {
        // 创建结果字符串
        StringBuffer sb = new StringBuffer();
        int index = 0;// 扫描字符串的指针
        // 先取出字符串的首字符——判断首字符是字母、数字、还是其他字符
        boolean isFirstWord = isWord(s.charAt(0));
        boolean isFirstNum = isNum(s.charAt(0));
        // 将获取到的字符串进行拆分，逐个字符逐个字符进行判断
        while (index < s.length()) {
            char temp = s.charAt(index);
            int replaceNum = 0;// 设置一个变量用于记录该字符串中的字符往后的移动个数
            if (!isFirstNum && !isFirstWord) {
                replaceNum = 1;
                sb.append(temp);
                index++;
                while (index < s.length()) {
                    temp = s.charAt(index);
                    sb.append(charToNewChar(temp, replaceNum));
                    index++;
                }
                return sb.toString();
            } else if (isFirstNum) {
                replaceNum = (int)(temp - '0');
            } else {
                replaceNum = (int)(temp - 'A' + 1);// A表示移动一位
            }
            // 判断其他字符是大写字母，还是数字，还是其他字符
            if (isWord(temp)) {
                sb.append(charToNewChar(temp, replaceNum));
            } else if (isNum(temp)) {
                sb.append(charToNewChar(temp, replaceNum));
            }
            index++;
        }
        return sb.toString();
    }

    // 编写一个函数用于做替换字符的操作
    public static char charToNewChar(char c, int i) {
        return isWord(c) ? charList.get((int)('c' + i - 'A') % 26) : intList.get((int)('c' + i - '0') % 10);
    }

    // 判断一个字符是不是字母
    public static boolean isWord(char ch) {
        // 判断他是不是出现在charList里面
        if (charList.contains(ch)) return true;
        return false;
    }

    // 判断一个字符是不是数字
    public static boolean isNum(char ch) {
        // 判断他是不是出现在intList里面
        if (intList.contains(ch)) return true;
        return false;
    }
}
