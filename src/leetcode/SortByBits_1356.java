package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByBits_1356 {

    int[] arr = {0,1,2,3,4,5,6,7,8};

    @Test
    public void sortByBits() {
        // 定义一个数组，用于存储原数组中每个数值二进制表示中1的个数
        int[] bit = new int[10001];// 0 <= arr[i] <= 10^4，所以数组大小为10001
        List<Integer> list = new ArrayList<>();
        // 将数组中的每个数存入list集合中去，同时把每个数二进制表示下的1的个数也存入对应的bit[]数组中
        for (int x : arr) {
            list.add(x);
            bit[x] = count(x);
        }
        // 重新对集合元素进行排序
        // 调用Collections中的sort方法，参数1：所在的集合，集合2：Comparator接口中的排序方法（此处用lambda表达式简写）
        Collections.sort(list, (x, y) -> {
            if (bit[x] != bit[y]) {
                // 如果两个数的二进制表示中1的个数不同，直接按照1的个数进行排序
                return bit[x] - bit[y];// 升序排序
            } else {
                // 如果两个二进制数的1数目相同，那就比较两个数的大小
                return x - y;// 升序排序
            }
        });
        // 将排序后的集合的值，赋给原数组，再进行输出
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        // 遍历输出数组中重新排序后的数值
        for (int val : arr) {
            System.out.print(val + "  ");
        }
    }

    // 统计该数字在二进制表示下的1的个数
    public int count(int number) {
        int res = 0;// 定义一个临时变量用于计数器：统计该数中1的个数
        while (number != 0 ){
            number = (number - 1) & number;
            res ++;
        }
        return res;
    }
}
