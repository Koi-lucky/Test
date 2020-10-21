package niuke.jz;

import org.junit.Test;

public class Add_48 {

    int num1 = 10;
    int num2 = 6;

    /**
     * 不带加减乘除符号，计算两数的和 —— > 位操作
     * 思路分析：
     * 1.先求出两数的 不带进位的加法运算 ——> 也就是“异或”（半加法运算）
     * 2.再求两数的 进位 ——> 也就是先“与”，再左移 1 位
     * 3.判断它的进位是不是 0 ，
     *      若是，则直接输出和值；
     *      若不是，则继续进行前几步的求和运算，直到进位的值为 0 为止
     */
    @Test
    public int Add( int num1, int num2) {
        // 定义一个变量用于存储最终结果值
        int result = 0;
        // 定义一个变量用于存储两数的半加法运算
        int sum = num1 ^ num2;
        // 定义一个变量用于存储两数的进位值
        int carry = (num1 & num2) << 1;
        // 判断进位是否为0
        if (carry == 0) {
            // 若为0则直接输出
            result = sum;
        } else {
            // 若不为0则继续进行前面的加法运算
            Add( sum, carry);
        }
        return result;
    }
}
