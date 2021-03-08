package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 22:21
 */
public class SingleNumber_56_2 {

    int[] nums = {9,4,5,9,5,5,9};

    @Test
    public void singleNumber() {
        // 位运算
        // 需要创建32个空间的整型数组，其他数字出现三次，他的每一位相加，再%3=0;如果最终结果 != 0，那他就是只出现一次的那个数
        // 最终，利用 左移操作 和 模余运算 ，可将 arr 数组中各二进位的值恢复到数字 res 上


        int[] arr = new int[32];
        for (int val : nums) {
            int div = 1;
            for (int i = 31; i >= 0; i--) {// 从数组的最末尾开始判断 —— 也就是一个数的最低位开始判断
                if ((div & val) != 0) {// 判断该位是不是1
                    arr[i]++;
                }
                // div右移，判断下一位是不是1
                div <<= 1;
            }
        }
        int res = 0;
        // 还原数字res —— 通过不断地 左移 + 模余 操作（也就相当于将一个数从最低位开始拼接而成一个数）
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += arr[i] % 3;
        }
        System.out.println(res);
    }
}
