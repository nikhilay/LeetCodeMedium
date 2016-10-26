/**
 * Created by Nikhil on 10/26/16.
 */

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of
 * those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.Ò
 */

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
    }

    public int integerBreak(int n) {
        if (n == 0) return 0;
        int[] memo = new int[n + 1];
        return dpIntegerBreak(n, memo);

    }

    private int dpIntegerBreak(int n, int[] memo) {
        if(memo[n]>0)return memo[n];
        int max = 1;
        for (int i = 1; i < n; i++) {
            int k= dpIntegerBreak(n - i, memo);
            max = Math.max(max, Math.max((n-i)*i,i * k));
        }
        memo[n] = max;
        return memo[n];

    }
}
