/**
 * Created by Nikhil on 12/2/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new LinkedList<>();
        int[] factorial = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int product = 1;
        factorial[0] = product;
        for (int i = 1; i < factorial.length; i++) {
            product *= i;
            factorial[i] = product;
        }
        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k = k - index * factorial[n - i];
        }
        return sb.toString();
    }
}
