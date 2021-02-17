package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 19:32
 */
public class MaxChunksToSorted_769 {

    int[] arr = {1,0,2,3,4};

    @Test
    public void maxChunksToSorted() {
        // 从头向后进行迭代，如果区间的索引值 = 数组的索引值，就得到了一个所求的区间
        // 当遍历到第i个位置时，如果可以切分块 —— 满足的条件：前i个位置的最大值一定等于i
        // 否则的话，一定会有比i小的数划分到后面的块，待那个块排序过后，一定不满足升序

        int res = 0, max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            // 统计前i个位置的最大值
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        System.out.println(res);
    }
}
