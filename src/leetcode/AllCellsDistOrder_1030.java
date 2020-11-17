package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/17 21:42
 */
public class AllCellsDistOrder_1030 {

    int R = 2;
    int C = 3;
    int r0 = 1;
    int c0 = 2;
    int[][] ret = new int[R * C][];

    @Test
    public void allCellsDistOrder() {
        //存储矩阵内所有的点
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        //　按照哈曼顿距离直接排序
        Arrays.sort(ret, (a, b) -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0)));// 前面参数 - 后面参数 （升序排序）
        // 输出数组
        for (int[] val : ret) {
            System.out.print(val + "  ");
        }
    }
}
