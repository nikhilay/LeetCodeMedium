/**
 * Created by Nikhil on 1/8/17.
 */

/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings
 * consisting of only 0s and 1s. Now your task is to find the maximum number of strings that you can form with given m
 * 0s and n 1s. Each 0 and 1 can be used at most once.
 * Note:
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 */

/**
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 Output: 4
 Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/71417/java-iterative-dp-solution-o-mn-space/16
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int[][] memo = new int[m + 1][n + 1];
        for (String s : strs) {
            int zeroes = 0;
            int ones = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroes++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    memo[i][j] = Math.max(memo[i][j], memo[i - zeroes][j - ones] + 1);
                }
            }
        }
        return memo[m][n];
    }
}
