package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/15 20:05
 */
public class PrintNumbers_17 {

    int n = 2;

    @Test
    public void printNumbers() {
        int[] nums = new int[(int)Math.pow(10, n) - 1];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        System.out.println(nums.toString());
    }
}
