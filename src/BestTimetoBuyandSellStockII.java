/**
 * Created by Nikhil on 10/26/16.
 */

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class BestTimetoBuyandSellStockII {


    public static void main(String[] args) {
        int[] input = {2, 1, 4};
        new BestTimetoBuyandSellStockII().maxProfit(input);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) sum += diff;
        }
        return sum;
    }

    /**
     *if (prices == null || prices.length == 0) return 0;
     int result = MINIMUM_PROFIT;
     int min = prices[0];
     int sum = 0;
     int x = min;
     for (int i = 1; i < prices.length; i++) {
     result = Math.max(result, prices[i] - min);
     min = Math.min(min, prices[i]);
     x =Math.min(x,prices[i]);
     if(prices[i] - x>0){
     sum+=prices[i] - x;
     x = prices[i];
     }
     }
     return Math.max(sum,result);
     }
     */
}
