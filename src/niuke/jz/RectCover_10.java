package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/10 9:39
 */
public class RectCover_10 {

    int target = 4;

    @Test
    public void RectCover() {
        // 特殊情况判断
        if (target == 0) {
            System.out.println(0);
            return;
        }
        if (target == 1) {
            System.out.println(1);
            return;
        }
        // 将中间计算的结果值用数组存储起来，以便于后面计算直接查找
        int[] arr = new int[target + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < target + 1; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        System.out.println(arr[target]);
    }
}
