/**
 * Created by Nikhil on 11/11/16.
 * <p>
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

import java.util.Arrays;

/**
 * Inspired from https://discuss.leetcode.com/topic/26400/an-easy-understanding-dp-solution-in-java/2
 */
public class PerfectSquares {
    private int leastCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        new PerfectSquares().numSquares(2);
    }


    //Efficient algo
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i <=n; i++) {
            int j =1;
            int min = Integer.MAX_VALUE;
            while(i -(j*j)>=0){
                min = Math.min(min, memo[(i)-(j*j)]+1);
                j++;
            }
            memo[i] = min;

        }
        return memo[n];
    }

    //Very slow because of lot of overlapping problems
    public int numSquaresSlow(int n) {
        helper(n, 0);
        return leastCount;
    }

    private void helper(int n, int depth) {
        if (n == 0) {
            leastCount = Math.min(leastCount, depth);
            return;
        }

        for (int i = 1; i * i <= n; i++) {
            helper(n - (i * i), depth + 1);
        }
        return;
    }


}
