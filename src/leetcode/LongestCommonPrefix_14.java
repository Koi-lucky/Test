package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix_14 {

    String[] strs = { "flower","flow","flight"};

    /**
     * 方法：哈希表
     * 思路分析：
     * 1.创建一个哈希表，存储数组中长度最短的那个值的每一个字符
     *      遍历数组，找到最小长度的那个值，
     *      再将值逐个分解加入到哈希表中
     * 2.设置一个临时变量用于存储前缀相同的值
     * 3.遍历数组每一个值，每个值的每一位与哈希表进行比较，若包含则向变量中加入这个字符，不包含则进行下一个数组值的判断
     */
    @Test
    public void longestCommonPrefix() {
        // 1.创建一个哈希表，存储数组中长度最短的那个值的每一个字符
        Set<String> set = new HashSet<>();
        // 遍历数组，找到最小长度的那个值，
        int len = strs[0].length();
        String s = "";// 用于存储最小长度的数组的值
        for (int i = 0;i < strs.length - 1; i++) {
            if (strs[i + 1].length() <= strs[i].length()) {
                len = strs[i + 1].length();
                s = strs[i + 1];
            }
        }
        // 再将值逐个分解加入到哈希表中
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                set.add(s.substring(i));
            } else {
                set.add(s.substring(i, i + 1));
            }
        }
        // 2.设置一个临时变量用于存储前缀相同的值
        StringBuilder ss = new StringBuilder();// 过程变量
        StringBuilder sss = new StringBuilder();// 存储最终数据的变量
        // 3.遍历数组每一个值，每个值的每一位与哈希表进行比较，
        // 若包含则向变量中加入这个字符，
        // 不包含则进行下一个数组值的判断
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (set.contains(strs[i].substring(j, j + 1))) {
                    ss = ss.append(strs[i].substring(j, j + 1));
                } else {
                    continue;
                }
            }
            if (ss.length() < sss.length()) {
                sss = ss;
                ss = ss.delete(0, ss.length() - 1);
            } else {
                ss = ss.delete(0, ss.length() - 1);
            }
        }
        System.out.println(sss.toString());
    }
}
