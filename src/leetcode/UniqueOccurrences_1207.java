package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences_1207 {

    int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};

    @Test
    public void uniqueOccurrences() {
        // 定义一个map集合，用于存储数组的值，及每个值出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put( val, map.getOrDefault( val, 0) + 1);
        }
        // 定义一个set集合，取map集合的值存入set中，以此来判断是否值是唯一出现的
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> vals : map.entrySet()) {
            if (set.contains(vals.getValue())) {
                System.out.println(false);
            }
            set.add(vals.getValue());
        }
        System.out.println(true);
    }
}
