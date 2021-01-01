package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/1 21:13
 */
public class CanPlaceFlowers_605 {

    int[] flowerbed = {1,0,0,0,1};
    int n = 2;

    @Test
    public void canPlaceFlowers() {
        int count = 0;// 计数器，用于统计可种植的花的个数
        int prev = -1;// 表示上一朵已经种植的花的下标位置，初始时 prev=−1，表示尚未遇到任何已经种植的花
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    // 下标l左边有l个位置，当l<2时无法在下标l左边种植花，当l≥2时可以在下标范围[0,l-2]范围内种植花，可以种植花的位置数是l−1，最多可以种植l/2朵花。
                    count += i / 2;
                } else {
                    // 无论p是奇数还是偶数,都是最多可以在该范围内种植(p+1)/2朵花，即最多可以在该范围内种植(j−i−2)/2朵花。
                    count += (i - prev - 2) / 2;
                }
                // 一旦count的数等于n，直接就可以返回，不用再计算后面的数
                if (count >= n) {
                    System.out.println(true);
                    break;
                }
                // 更新上一朵已经种植的花的下标位置
                prev = i;
            }
        }
        // 遍历数组结束后，根据数组 prev 和长度 m 的值计算最后一个区间内可以种植花的最多数量

        // 如果花坛上没有任何花朵，则有 m=flowerbed.length 个位置可以种植花，最多可以种植 (m+1)/2 朵花
        if (prev < 0) {
            count += (flowerbed.length + 1) / 2;
        } else {
            // 令m为数组flowerbed的长度，下标r右边有m−r−1个位置,可以种植花的位置数是m−r−2,最多可以种植(m−r−1)/2朵花
            count += (flowerbed.length - prev - 1) / 2;
        }
        // 判断整个花坛内可以种入的花的最多数量是否 大于或等于 n
        System.out.println(n <= count);
    }
}
