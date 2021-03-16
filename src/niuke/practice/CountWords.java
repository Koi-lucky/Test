package niuke.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/16 20:42
 */
public class CountWords {

    public static void main(String[] args) {
        // 考虑边界值——n的大小是否合规范、字符串的长度总和是否合规范


        // 1.按行输入对应的数据
        // 2.读取输入的数据
        // 3.编写一个函数计算一个字符串出现的概率
        // 4.统计所有输入的字符串出现的次数>1%的情况


        // 创建一个HashMap集合，用于存储整篇文章的每个字符串
        Map<String, Integer> map = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        while (n > 0) {
            String str = input.nextLine();
            map.put( str, map.getOrDefault( str, 0) + 1);
            n--;
        }
        System.out.println(countStr(map, n));
    }

    // 编写一个函数 —— 用于计算该字符串在整篇文章中出现的概率
    // 先用HashMap统计出现的次数，再进行概率的计算
    // 参数n代表总的字符串个数
    public static int countStr(Map<String, Integer> map, int n) {
        int count = 0;
        // 遍历集合，更改集合中的value部分的值
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String,Integer> val : entries) {
            // 修改key对应的值
            double result = val.getValue() / (n * 1.0);
            if (result > 0.01) {
                count++;
            }
        }
        return count;
    }
}
