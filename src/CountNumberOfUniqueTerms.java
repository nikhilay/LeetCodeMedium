/**
 * Created by Nikhil on 10/26/16.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumberOfUniqueTerms {
    public static void main(String[] args) {
        new CountNumberOfUniqueTerms().countNumbersWithUniqueDigitsEfficient(3);
    }

    //Efficient Way
    public int countNumbersWithUniqueDigitsEfficient(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        if(n==0) return memo[0];
        memo[1] = 9;
        int count = memo[1] + memo[0];
        if (n == 1) return count;

        int currentNumber = 9;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] * currentNumber;
            currentNumber = currentNumber > 0 ? --currentNumber : 0;
            count+=memo[i];
        }n
        return count;
    }

    //Naive Solution
    public int countNumbersWithUniqueDigits(int n) {
        double limit = Math.pow(10, n);
        int count = 0;
        for (int i = 0; i < limit; i++) {
            if (isUniqueInteger(i)) count++;
        }
        return count;
    }

    private boolean isUniqueInteger(int n) {
        HashSet<Integer> hset = new HashSet<>();
        while (n != 0) {
            int digit = n % 10;
            n = n / 10;
            if (hset.contains(digit)) return false;
            hset.add(digit);
        }
        return true;
    }
}
