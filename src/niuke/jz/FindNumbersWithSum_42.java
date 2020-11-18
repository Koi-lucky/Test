package niuke.jz;

import org.junit.Test;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/18 14:37
 */
public class FindNumbersWithSum_42 {

    int[] array = {1,2,4,7,11,15};
    int sum = 15;

    @Test
    public void FindNumbersWithSum() {
        ArrayList<Integer> list = new ArrayList<>();
        // 定义两个指针，一个指向数组头一个指向数组尾
        int left = 0;
        int right = array.length - 1;
        // 遍历数组，判断两个数的和是否为sum
        while (left < right) {
            if (array[right] == (sum - array[left])) {
                list.add(array[left]);
                list.add(array[right]);
                break;
            } else if (array[right] > (sum - array[left])) {
                right--;
            } else {
                left++;
            }
        }
        // 输出
        for (Integer value : list) {
            System.out.print(value + " ");
        }
    }
}
