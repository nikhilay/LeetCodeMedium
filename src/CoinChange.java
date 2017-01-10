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

/**
 * Inspired from
 * https://www.youtube.com/watch?annotation_id=annotation_2195265949&feature=iv&src_vid=Y0ZqKpToTic&v=NJuKJ8sasGk
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        int[] memo = new int[amount+1];
        for(int i=1;i<memo.length;i++){
            memo[i]= Integer.MAX_VALUE-1;
        }
        for(int i=1;i<memo.length;i++ ){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]) memo[i]= Math.min(memo[i],memo[i-coins[j]]+1);
            }

        }
        return memo[amount]==Integer.MAX_VALUE-1?-1:memo[amount];

    }
}
