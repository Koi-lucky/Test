package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/8 22:58
 */
public class Rotate_189 {

    int[] nums = {1,2,3,4,5,6,7};
    int k = 3;

    @Test
    public void rotate() {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
