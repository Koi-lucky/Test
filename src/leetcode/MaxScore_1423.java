package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/6 14:37
 */
public class MaxScore_1423 {

    int[] cardPoints = {1,79,80,1,1,1,200,1};
    int k = 3;

    @Test
    public void maxScore() {
        // 滑动窗口
        // 已知数组长度n和k值，让滑动窗口的窗口值为n-k。
        // 每次求出活动窗口中的值，并最终求得窗口的最小值（反过来，也就是结果值最大的情况）
        // 用数组的总和 - 滑动窗口的最小值 = 结果值

        int len = cardPoints.length;// 数组的长度
        int windowSize = len - k;// 滑动窗口的大小为n-k
        int curSum = 0;
        // 选取数组前n-k个值为初始值
        for (int i = 0; i < windowSize; i++) {
            curSum += cardPoints[i];
        }
        int minWindowSum = curSum;// 滑动窗口的最小和
        // 求滑动窗口的最小值
        for (int i = windowSize; i < len; i++) {
            // 滑动窗口不断右移，删去窗口最左侧的数值，加入窗口右边的下一个数值
            curSum += cardPoints[i] - cardPoints[i - windowSize];
            // 两个minWindowSum里面取最小值
            minWindowSum = Math.min( minWindowSum, curSum);
        }

        int arrSum = 0;
        // 求出数组的总和
        for (int value : cardPoints) {
            arrSum += value;
        }
        System.out.println(arrSum - minWindowSum);
    }
}
