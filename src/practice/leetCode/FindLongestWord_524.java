package practice.leetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/21 0:16
 */
public class FindLongestWord_524 {

    String s = "abpcplea";
    List<String> d = Arrays.asList( "ale","apple","monkey","plea");

    /**
     * 比较两个数的字典顺序：
     *
     *  简单来说，String类的compareTo()方法是用来比较两个字符串的字典顺序。
     *   用字符串1跟字符串2作比较，如果字符串1的字典顺序在字符串2前面，则返回一个负数。若在后面，则返回一个正数。若两个字符串的字典顺序相同，则返回0。
     *   这里的字典顺序指的是ASCII码表中的字符顺序。ASCII表中每个字符都有对应的下标，从0开始升序排列，共128个字符。
     *  【比较字典顺序的规则】
     *      字符串1的第一个字符跟字符串2的第一个字符不相等，则两个字符串都按照第一个字符的ASCII码顺序进行比较，其他字符都不用看，并返回一个整型。
     */
    @Test
    public void findLongestWord() {
        // 定义一个字符串用于存储结果值
        String targetStr = "";
        for (int i = 0; i < d.size(); i++) {
            int len1 = targetStr.length();// 结果字符串的长度
            int len2 = d.get(i).length();// 集合中当前得到的字符串的长度
            if (len1 > len2 || ( len1 == len2 && targetStr.compareTo(d.get(i)) < 0 )) {
                continue;
            }
            // 判断targetStr是不是字符串s的字串,如果是则记录targetStr的内容
            if (isSubStr( s, d.get(i))) {
                targetStr = d.get(i);
            }
        }
        System.out.println(targetStr);
    }

    // 编写一个函数 —— 判断一个字符串target是不是字符串s的子串
    public boolean isSubStr(String s, String target) {
        // 定义两个指针扫描字符串
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            // 如果两个字符相等,让指向target字符串的指针后移
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;// 不管相等不相等，指向s串的指针都得后移
        }
        return j == target.length();
    }
}
