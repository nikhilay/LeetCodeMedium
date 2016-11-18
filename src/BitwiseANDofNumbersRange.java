/**
 * Created by Nikhil on 11/17/16.
 */

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/12133/bit-operation-solution-java/7 
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int move = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            move++;
        }
        return m << move;
    }

}
