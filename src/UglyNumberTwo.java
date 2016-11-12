/**
 * Created by Nikhil on 11/12/16.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */

/**
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/22982/java-easy-understand-o-n-solution .
 */
public class UglyNumberTwo {
    public int nthUglyNumber(int n) {
        int[] memo = new int[n];
        memo[0] = 1;
        int a = 0, b = 0, c = 0;

        for (int i = 1; i < n; i++) {
            int valA = memo[a] * 2;
            int valB = memo[b] * 3;
            int valC = memo[c] * 5;
            int nextVal = Math.min(valA, Math.min(valB, valC));
            memo[i] = nextVal;
            if (nextVal == valA) a++;
            if (nextVal == valB) b++;
            if (nextVal == valC) c++;
        }

        return memo[n - 1];

    }
}
