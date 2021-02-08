package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/8 15:08
 */
public class MaxTurbulenceSize_978 {

    int[] arr = {9,4,2,10,7,8,8,1,9};

    @Test
    public void maxTurbulenceSize() {
        // 滑动窗口解决
        // 要让窗口内（[left,right]）构成一个湍流数组
        // 必须满足以下条件
        // 1.需要特殊考虑窗口长度为1(即 left 和 right 相等的情况)：只要 arr[right]=arr[right+1]，就可以将 right 右移一个单位；否则，left 和 right 都要同时右移
        // 2.当满足arr[right - 1] < arr[right] 并且 arr[right] > arr[right + 1],此时满足湍流数组的条件，right指针后移
        // 3.当满足arr[right - 1] > arr[right] 并且 arr[right] < arr[right + 1],此时也满足湍流数组的条件，right指针后移
        // 4.若以上的条件2,3都不满足，此时应该将滑动窗口的位置进行变动，也就是让left=right
        // 做以上操作时，一定要取窗口大小的最大值

        int left = 0, right = 0;
        int len = 1;// 窗口大小
        while (right < arr.length - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right] > arr[right - 1] && arr[right + 1] < arr[right]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            len = Math.max(len, right - left + 1);
        }
        System.out.println(len);
    }
}
