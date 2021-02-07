package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/7 18:45
 */
public class CheckPossibility_665 {

    int[] nums = {3,4,2,3};

    @Test
    public void checkPossibility() {
        // 特殊情况判断
        if (nums.length <= 1 || nums == null) {
            System.out.println(true);
            return;
        }
        // 遍历数组
        // 通过一个计数器来判断是否有不止一个情况nums[i] > nums[i+1]
        // 如果满足nums[i] > nums[i+1]的情况，判断是否可以通过一次交换nums[i+1]=nums[i],得到非递减序列
        int count = 0;// 计数器
        for (int i = 0; i < nums.length - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                count++;
                if (count > 1) {
                    System.out.println(false);
                    return;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        System.out.println(true);
    }
}
