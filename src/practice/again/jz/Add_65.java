package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/3 21:31
 */
public class Add_65 {

    int a = 1;
    int b = 1;

    @Test
    public void add() {
        // 位运算实现
        // 异或运算相等于【无进位的加法运算】
        // 进位 就是【a和b进行 与 运算 ，再将结果左移一位】
        // 将 异或 的值 与 与运算的值 进行加和 就是结果值

        while (b != 0) {// 当进位为0时跳出
            int c = (a & b) << 1;// 进位
            a = a ^ b;// 无进位的加法运算
            b = c;// 进位
        }
        // 如果b=0，就返回a的值
        System.out.println(a);
    }
}
