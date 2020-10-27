package niuke.jz;

import org.junit.Test;

public class NumberOf1_12 {

    int n = 77;

    @Test
    public void numberOf1() {
        int count = 0;// 计数器
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        System.out.println(count);
    }
}
