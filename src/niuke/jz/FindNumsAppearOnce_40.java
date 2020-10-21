package niuke.jz;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class FindNumsAppearOnce_40 {

    int[] array = { 1, 1, 5, 8, 8, 4, 2, 3, 3, 2};
    int[] num1 = new int[1];
    int[] num2 = new int[1];

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 思路分析： 哈希表
     * 1.将数组中的每一个数都存入哈希表中
     * 2.如果有相同的数，删除哈希表中那些相同的数，最终结果哈希表中会只剩 两个数
     * 3.将剩余的两个数，存入两个数组中输出
     */
    @Test
    public void FindNumsAppearOnce() {
        // 1.将数组中的每一个数都存入哈希表中
        Set<Integer> set = new HashSet<>();
        // 2.如果有相同的数，删除哈希表中那些相同的数，最终结果哈希表中会只剩 两个数
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
        // 3.将剩余的两个数，存入两个数组中输出
        int[] a = new int[2];
        int k = 0;
        // 从set中取出数
        for (Integer val : set) {
            a[k] = val;
            k++;
        }
        num1[0] = a[0];
        num2[0] = a[1];
        System.out.println(num1[0] + "  " +num2[0]);
    }
}
