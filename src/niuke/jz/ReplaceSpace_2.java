package niuke.jz;

import org.junit.Test;

public class ReplaceSpace_2 {

    StringBuffer str = new StringBuffer("we are happy");

    @Test
    public void replaceSpace() {
        // 从后向前进行字符串替换

        int length = str.length();// 定义一个临时变量存储原字符串的长度
        // 查找字符串中 空格 的个数
        int i = 0;
        int count = 0;// 计数器：用于统计字符串中 空格 的个数
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                count++;
            }
            i++;
        }
        int newLength = str.length() + count * 2; // 定义一个临时变量存储new字符串的长度 —— 旧字符串的长度 + 空格数 * 2
        // 定义两个指针
        int index = length - 1;// 指向原字符串的末尾
        int newIndex = newLength - 1;// 指向新字符串的末尾
        // 更新str的长度
        str.setLength(newLength);
        while (index >= 0 && index < newIndex) {
            // 如果原数组的最后一个字符是 空格 ，新字符串的指针需要 左移三位，每移一位，就替换对应的字符
            if (str.charAt(index) == ' ') {
                // 替换字符串中的空格
                str.setCharAt( newIndex--, '0');
                str.setCharAt( newIndex--, '2');
                str.setCharAt( newIndex--, '%');
            } else {
                // 如果原数组的最后一个字符是 非空格的字符 ，新字符串的指针只需要 左移一位，每移一位，就赋值原字符串指针指向的对应的字符
                str.setCharAt( newIndex--, str.charAt(index));
            }
            // 不论是何种字符，原数组的指针始终都左移一位
            index--;
        }
        System.out.println(str.toString());
    }
}
