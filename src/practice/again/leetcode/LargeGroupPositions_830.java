package practice.again.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/5 16:42
 */
public class LargeGroupPositions_830 {

    String s = "aaa";

    @Test
    public void largeGroupPositions() {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;// 定义一个临时变量用于统计每个字符出现的次数
        for (int i = 0; i < n; i++) {
            // 此处要判断是不是最后一个字母
            // 还需要判断当前的字母是不是该相等字符序列中的最后一个字母
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                // 如果该字母出现的次数>=3次的话，将其加入答案集合中
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        for (List<Integer> val : ret) {
            System.out.println(val);
        }
    }
}
