package practice.again.jz;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 15:53
 */
public class FirstUniqChar_50 {

    String s = "abaccdeff";

    @Test
    public void firstUniqChar() {
        // 第一次遍历：用哈希表统计字符串中每个字符出现得次数
        // 第二次遍历：遍历字符串，找到第一个出现一次的字符

        // 特殊情况判断
        if (s.length() == 0 || s == null) {
            System.out.println(' ');
        }
        Map<Character, Boolean> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (char val: ch) {
            map.put(val, !map.containsKey(val));
        }
        for (char val: ch) {
            if (map.get(val)) {
                System.out.println(val);
                return;
            }
        }
        System.out.println(' ');
    }
}
