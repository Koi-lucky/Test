package practice.jzOffer;

import java.util.HashSet;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/5/27 22:48
 */
public class Duplicate_50 {

    public static int duplicate (int[] numbers) {
        // write code here
        // 特殊情况
        if (numbers.length < 2) {
            return -1;
        }
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int val: numbers) {
            if (set.contains(val)) {
                res = val;
                break;
            }
            set.add(val);
        }
        return res;
    }

    public static void main(String[] args) {
        // 测试
        int[] numbers = {2,3,1,0,2,5,3};
        System.out.println(duplicate(numbers));
    }
}
