
/**
 * Created by Nikhil on 12/6/16.
 */

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/35840/java-clean-dp-solution-with-explanation
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int len = s.length();
        int[] memo = new int[len + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                memo[i] += memo[i - 1];
            }
            if (second >= 10 && second <= 26) {
                memo[i] += memo[i - 2];
            }

        }
        return memo[len];

    }
}
