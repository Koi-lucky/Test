package practice.again.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/9 19:57
 */
public class HammingWeight_15 {

    int n = 11;

    @Test
    public void hammingWeight() {
        int res = 0;//统计1个数
        while(n != 0) {
            res ++;
            n = n & (n - 1);//每次消去一个1
        }
        System.out.println(res);
    }
}
