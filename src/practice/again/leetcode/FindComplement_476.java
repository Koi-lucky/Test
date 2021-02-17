package practice.again.leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/17 21:52
 */
public class FindComplement_476 {

    int num = 5;

    @Test
    public void findComplement() {
        // 通过位运算获取最大位数的位置，然后利用异或操作进行取反

        int maxBitNum = 0;
        int tmpNum = num;
        while (tmpNum > 0) {
            maxBitNum += 1;
            tmpNum = tmpNum >> 1;
        }
        System.out.println(num ^ ((1 << maxBitNum) - 1));
    }
}
