package leetcode;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/8 22:22
 */
public class MaxProfit_121 {

    int[] prices = {7,1,5,3,6,4};

    @Test
    public void maxProfit1() {
        if (prices.length == 0 || prices.equals(" ")) {
            System.out.println(0);
        }

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        System.out.println(maxprofit);
    }

    @Test
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {  // 卖出有利可图
                ans += (prices[i] - prices[i-1]);
            }
        }

        return ans;
    }
}
