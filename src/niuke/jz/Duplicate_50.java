package niuke.jz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Duplicate_50 {

    int[] numbers = { 2, 3, 1, 0, 2, 5, 3};
    int length = 7;
    int[] duplication = new int[2];

    /**
     * 方法一：用集合进行操作
     */
    @Test
    public void duplicate() {
        // 创建一个set集合，用于存储数组中的值，方便判断及操作重复的数
        List<Integer> list = new ArrayList<Integer>();
        // 将数组中的数存入set集合中，并进行判断
        for (int i = 0; i < length; i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                System.out.println(true);
            }
            list.add(numbers[i]);
        }
        // 找到重复的数了，进行赋值

        System.out.println(false);
    }
    /**
     * 方法二：用双指针进行操作
     */
    @Test
    public void duplicate1() {
        // 双层for循环
        for (int i = 0; i < length; i++) {
            for (int j = i +1; j < length; j++) {
                if (numbers[i] == numbers[j]) {
                    duplication[0] = numbers[i];
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }


}
