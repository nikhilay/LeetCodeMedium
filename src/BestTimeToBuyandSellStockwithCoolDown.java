/**
 * Created by Nikhil on 11/1/16.
 */

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyandSellStockwithCoolDown {
    public static void main(String[] args) {
        int[] input = {2, 1, 2, 0, 1};
        new BestTimeToBuyandSellStockwithCoolDown().maxProfit(input);
    }

    /**
     * you have 1 stock and you sell it
     * you have 1 stock and you do nothing
     * you have 0 stock and you buy stock i
     * you have 0 stock and you do nothing
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int has0_Donothing = 0;
        int has1_Donothing = -prices[0];
        int has1_sell = 0;
        int has0_buy = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            has1_Donothing = Math.max(has0_buy,has1_Donothing);
            has0_buy = has0_Donothing -prices[i];
            has0_Donothing = Math.max(has0_Donothing,has1_sell);
            has1_sell = Math.max(has1_Donothing,has0_buy)+prices[i];

        }
return Math.max(has1_sell,has0_Donothing);
    }
}
