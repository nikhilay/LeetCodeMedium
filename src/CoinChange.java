/**
 * Created by Nikhil on 12/12/16.
 */


/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        int[] memo = new int[amount];
        return helper(coins, amount, memo);

    }

    private int helper(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        if(memo[amount-1]!=0) return memo[amount-1];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int coin = 1;
            int remainingCoin = helper(coins, amount-coins[i],memo);
            if (remainingCoin >= 0) {
                coin += remainingCoin;
                min = Math.min(coin, min);
            }
        }
        memo[amount-1] = (min == Long.MAX_VALUE )? -1 : (int) min;
        return memo[amount-1];
    }
}
