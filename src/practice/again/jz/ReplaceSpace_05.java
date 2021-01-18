package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/18 20:06
 */
public class ReplaceSpace_05 {

    String s = "We are happy.";

    @Test
    public void replaceSpace() {
        // 扫描字符串，统计出现的空格数
        // 创建字符数组，数组的长度需计算
        // 将字符串存入数组内
        // 双指针法解决
        // 从后往前遍历数组
        // left指针扫描数组前面的单词序列
        // right指针从数组的末尾进行填充
        // 如果left指针遇到空格，right指针就依次倒序填充02%
        // 更新两个指针

        int countSpace = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                countSpace++;
            }
        }
        char[] ch = new char[s.length() + countSpace*2];
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }
        int left = s.length() - 1, right = ch.length - 1;
        while (left >= 0 && right >= 0 && left < right) {
            if (ch[left] == ' ') {
                ch[right--] = '0';
                ch[right--] = '2';
                ch[right--] = '%';
                left--;
            } else {
                ch[right--] = ch[left--];
            }
        }
        System.out.println(new String(ch));
    }
}
