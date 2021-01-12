package practice.again.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/12 20:54
 */
public class FourSumCount_454 {

    int[] A = {1,2};
    int[] B = {-2,-1};
    int[] C = {-1,2};
    int[] D = {0,2};

    @Test
    public void fourSumCount() {
        // 利用map解决
        // 先求出前两个数组的和 并存入map中
        // 求出后两个数组的和，此时，在map里面判断是否有key 等于 后两个数组的和 —— 若存在，在map中出现过的话，就把map中key对应的value也就是出现次数统计出来。
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int count = 0;// 计数器
        for (int i : C) {
            for (int j : D) {
                if (map.containsKey(0 - (i + j))) {
                    // 若存在，在map中出现过的话，就把map中key对应的value也就是出现次数统计出来。
                    count += map.get(0 - (i + j));
                }
            }
        }
        System.out.println(count);
    }
}
