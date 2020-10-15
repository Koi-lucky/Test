package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars_1002 {

    String[] A = { "bella","label","roller"};

    /**
     * 【思路】统计每个个字符串中的字符出现的次数ans[],在让他和当前字符串中字符出现次数进行比较，取最小值minAns[]，不断地更新当前最小字符数组的值
     * 思路分析：
     * 1.定义两个数组，一个用于存储统计每一个字符串中字符出现的个数，一个用于存储统计某个字符A在所有字符串中出现的最小次数
     * 2.依次遍历每一个字符串，在遍历到字符串S时，统计他每一个字符出现的次数
     * 3.统计完之后，再将每一个字符出现的次数 与 他在总数组中出现的次数进行比较，取最小值
     * 4.最终结果，要将在数组中出现最小次数个字符C输出
     */
    @Test
    public void commonChars() {
        List<String> list = new ArrayList<>();
        int[] minAns = new int[26];// 只有小写字母
        // 先给数组中充满最大数，方便之后的比较
        Arrays.fill( minAns, Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            int[] ans = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                // 统计每个个字符串中的字符出现的次数ans[],
                char ch = A[i].charAt(j);
                ans[ch - 'a']++;
            }
            // 再让他和当前字符串中字符出现次数进行比较，取最小值minAns[]，不断地更新当前最小字符数组的值
            for (int k = 0; k < 26; k++) {
                minAns[k] = Math.min( minAns[k], ans[k]);
            }
        }

        // 将数组中的数转为对象的字符，输出到集合中
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minAns[i]; j++) {
                list.add(String.valueOf((char)(i + 'a')));
            }
        }
        System.out.println(list);
    }
}
