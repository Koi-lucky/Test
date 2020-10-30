package niuke.jz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar_34 {

    String str = "xbuiabcigib";

    @Test
    public void FirstNotRepeatingChar() {
        // 特殊情况判断
        if (str == null) {
            System.out.println(0);
            return;
        }
        // 定义一个map集合用于存储字符串中每个字符，及每个字符出现的次数
        Map< Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            // 将字符串中每个字符，及每个字符出现的次数 存入 map集合中
            map.put( str.charAt(i), map.getOrDefault( str.charAt(i), 0) + 1);
        }
        // 循环map集合，找到那个只出现一次的字符，并输出
        for (Map.Entry<Character, Integer> val : map.entrySet()) {
            // 判断该key是否只出现了一次
            if (val.getValue() == 1) {
                System.out.println(val.getKey());
                return;
            }
        }
        System.out.println(0);
    }
}
