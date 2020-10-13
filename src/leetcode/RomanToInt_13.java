package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RomanToInt_13 {

    String s = "MCMXCIV";

    /**
     * 方法：哈希表
     * 思路分析：
     * 1.将所有的可能列出来，并且存在哈希表中
     * 2.遍历字符串，所扫描的字符只有两种可能：一个字符或者两个字符，（两个字符的优先级 大于 一个字符的优先级）
     * 3.遍历到两个字符后，取出这两个字符，指针后移两位
     * 4.遍历到一个字符后，取出这一个字符，指针后移一位
     */
    @Test
    public void romanToInt() {
        // 1.将所有的可能列出来，并且存在哈希表中
        Map<String, Integer> map = new HashMap<>();
        map.put( "I", 1);
        map.put( "IV", 4);
        map.put( "V", 5);
        map.put( "IX", 9);
        map.put( "X", 10);
        map.put( "XL", 40);
        map.put( "L", 50);
        map.put( "XC", 90);
        map.put( "C", 100);
        map.put( "CD", 400);
        map.put( "D", 500);
        map.put( "CM", 900);
        map.put( "M", 1000);
        // 2.遍历字符串，所扫描的字符只有两种可能：一个字符或者两个字符，（两个字符的优先级 大于 一个字符的优先级）
        int ans = 0;//临时变量，用于存储实际数据
        for (int i = 0; i < s.length(); ) {
            // 3.遍历到两个字符后，取出这两个字符，指针后移两位
            if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                // 4.遍历到一个字符后，取出这一个字符，指针后移一位
                ans += map.get(s.substring(i, i + 1));
                i += 1;
            }
        }
        System.out.println(ans);
    }
}
