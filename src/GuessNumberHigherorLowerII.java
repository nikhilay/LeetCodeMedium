/**
 * Created by Nikhil on 11/14/16.
 */

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x,
 * and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * Example:
 * n = 10, I pick 8.
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * Game over. 8 is the number I picked.
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherorLowerII {

    /**
     * you strategy is the best, but your luck is the worst
     */
    /**
     * For each number x in range[i~j]
     * we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
     * --> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
     * then we get DP([i~j]) = min{xi, ... ,xj}
     * --> // this min makes sure that you are minimizing your cost.
     */
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int[][] memo = new int[n + 1][n + 1];

        for (int len = 1; len < n; len++) {
            for (int i = 1; i + len <= n; i++) {
                int j = i + len;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = k + Math.max(memo[i][k - 1], memo[k + 1][j]);
                    min = Math.min(temp, min);
                }
                memo[i][j] = min;
            }
        }

        return memo[1][n];
    }
}
