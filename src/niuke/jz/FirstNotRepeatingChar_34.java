package niuke.jz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar_34 {

    String str = "google";

    @Test
    public void FirstNotRepeatingChar() {
        // 特殊情况判断
        if (str == null || str.length() <= 0) {
            System.out.println(-1);
            return;
        }
        // 定义一个map集合用于存储字符串中每个字符，及每个字符出现的次数
        Map< Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            // 将字符串中每个字符，及每个字符出现的次数 存入 map集合中
            map.put( str.charAt(i), map.getOrDefault( str.charAt(i), 0) + 1);
        }
        // 遍历字符串，找出在集合中出现次数为1的字符
        for(int i = 0; i < str.length();i++){
            if(map.get(str.charAt(i)) == 1){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
