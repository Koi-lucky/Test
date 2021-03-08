package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/8 20:44
 */
public class MyPow_16 {

    double x = 2.00000;
    int n = 10;

    @Test
    public void myPow() {
        // 1.判断是奇次幂还是偶次幂：偶次幂: n/2 * n/2;奇次幂：n/2 * n/2 * x
        // 2.判断是正数幂还是负数幂：正数幂：res ;负数幂：1/res

        boolean isNegative = false;// 标志位：判断是不是负数幂
        if (n < 0) {
            n = -n;
            isNegative = true;
        }
        double res = power(x,n);
        System.out.println(isNegative ? 1 / res : res);
    }

    // 判断是奇次幂还是偶次幂
    public double power(double x, int n) {
        // 用二分法对n次幂进行划分为两个n/2
        // 再利用递归将n/2再次划分

        // 递归出口
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        // 单层递归逻辑
        double res = power(x, n / 2);// 分治（二分）
        res = res * res;
        if (n % 2 != 0) {
            return res * x;
        }
        // 递归返回值
        return res;
    }
}
