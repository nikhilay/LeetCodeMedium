/**
 * Created by Nikhil on 10/26/16.
 */

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of
 * those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.Ò
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/45341/a-simple-explanation-of-the-math-part-and-a-o-n-solution/2
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n = n - 3;
        }
        product *= n;
        return product;
    }
}
