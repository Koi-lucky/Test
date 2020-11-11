package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/10 20:35
 */
public class Power_12 {

    double base = 2;
    int exponent = 3;

    @Test
    public void Power() throws Exception {
        // 1.特殊情况判断 —— 底数和指数不能同时为0；当指数为负数时，底数不能为0（结果值要进行求倒，0不能做分母）
        if (equalsTwoNum(base, 0.0) && exponent <= 0) {
            throw new Exception("输入参数有误");
        }
        // 2.判断指数是 正整数 还是 负数 —— 如果是正整数，不作操作；如果是负数，给绝对值
        int unsigdedExponent = exponent;
        if (exponent < 0) {
            unsigdedExponent = - exponent;
        }
        // 3.计算结果值
        double result = powerUnsignedExponent( base, unsigdedExponent);
        // 4.如果指数是负数，将结果值进行求倒；如果是正整数，不作操作
        if (exponent < 0) {
            result = 1.0 / result;
        }
        System.out.println(result);
    }

    // 求两个浮点数（float或者double）是否相等 —— 两个浮点数之差的【绝对值】是不是在一个很小的范围内
    public boolean equalsTwoNum(double num1, double num2) {
        if ((num1 - num2 > - 0.0000001) && (num1 - num2 < 0.0000001)) {
            return true;
        }
        return false;
    }

    // 求无符号指数的次方值 —— 如果指数是正整数就直接计算，如果是负数，先求指数绝对值，再求结果值的倒数
    public double powerUnsignedExponent(double base, int unsignedExponent) {
        double result = 1.0;
        for (int i = 1; i <= unsignedExponent; i++) {
            result *= base;
        }
        return result;
    }
}
