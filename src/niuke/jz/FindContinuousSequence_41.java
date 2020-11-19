package niuke.jz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/18 14:49
 */
public class FindContinuousSequence_41 {

    int sum = 100;

    @Test
    public void FindContinuousSequence() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        // 特殊情况判断
        if (sum < 3) {
            return;
        }
        // 定义操作的指针
        int small = 1;// 最小的数 初值从最小的数1开始
        int big = 2;// 最大数 初值从2开始
        int middle = (1 + sum) / 2;
        int curSum = small + big;// 最终结果值

        while (small < middle) {
            // 如果目前的值curSum==sum
            if (curSum == sum) {
                list2.add(list1);
                break;
            }
            // 如果当前的和curSum > sum
            while (curSum > sum && small < middle) {
                // 先减掉之前的值，再进行数的后移
                curSum -= small;
                small++;
                list1.add(small);
                // 如果目前的值curSum==sum
                if (curSum == sum) {
                    list2.add(list1);
                    break;
                }
            }
            // 如果当前的和curSum < sum
            big++;
            curSum += big;
            list1.add(big);
        }
        // 输出集合list2
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                System.out.print(list1.get(j) + " ");
            }
            System.out.println();
        }
    }
}
