package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate_287 {

    int[] a = { 1, 3, 4, 2, 2};
    @Test
    public void findDuplicate() {
        // 创建一个set集合
        Set<Integer> set = new HashSet<>();
        int k = -1;// 定义一个临时变量用于存储重复的数
        // 遍历数组，将数组中的每个数都添加到set集合中去，同时判断是否重复，若重复，则输出重复的那个数
        for (int val : a) {
            if (set.contains(val)) {
                k = val;
            }
            set.add(val);
        }
        System.out.println(k);
    }
}
