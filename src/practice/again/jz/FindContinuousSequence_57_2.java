package practice.again.jz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 21:22
 */
public class FindContinuousSequence_57_2 {

    int target = 9;

    @Test
    public void findContinuousSequence() {
        // 滑动窗口
        // 两个指针移动均单调不减，且最多移动 target/2次
        // 如果sum>target,左指针右移，并且得减掉刚退出窗口的值
        // 如果sum<target，右指针右移，并且加上刚进来窗口的值
        // 如果相等，创建数组，并将窗口内的数存进去

        List<int[]> list = new ArrayList<>();
        int left = 1, right = 1;
        int sum = 0;
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                list.add(arr);
                // 移动滑动窗口的左边界，继续向后查找
                sum -= left;
                left++;
            }
        }
        System.out.println(list.toArray(new int[list.size()][]));
    }
}
