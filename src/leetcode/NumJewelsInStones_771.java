package leetcode;

import java.util.*;

public class NumJewelsInStones_771 {

    public static void main(String[] args) {
        //测试用例
        String J = "aA";
        String S = "aAAbbbb";

        System.out.println(numJewelsInStones2( J, S));
    }

    /*
    * 方法一：暴力法，直接进行双重循环遍历
    * */
    public static int numJewelsInStones1(String J, String S) {
        //定义一个临时变量用于存储宝石的个数
        int count = 0;

        //双重循环嵌套来判断石头中宝石的个数
        for (int i = 0; i < S.length(); i++) {
            char ch1 = S.charAt(i);
            for (int j = 0; j < J.length(); j++) {
                char ch2 = J.charAt(j);
                if ( ch1 == ch2) {
                    count++;
                }
            }
        }
        return count;
    }


    /*
    * 方法二：hashset来给字符串J去重
    * */
    public static int numJewelsInStones2(String J, String S) {
        //定义一个临时变量用于存储宝石的个数
        int count = 0;

        //先定义一个set集合，来给J去重
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        //遍历字符串S，判断set里面是否有包含
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
           if(set.contains(ch)) {
               count++;
           }
        }
        return count;
    }
}
