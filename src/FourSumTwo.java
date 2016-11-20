/**
 * Created by Nikhil on 11/20/16.
 */

import java.util.HashMap;

/**
 * Inspired from
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
 * there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * Example:
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * Output:
 * 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/67658/simple-java-solution-with-explanation
 */
public class FourSumTwo {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null || A.length == 0
                || B.length == 0 || C.length == 0 || D.length == 0)
            return 0;

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (hmap.containsKey(sum)) {
                    hmap.put(sum, hmap.get(sum) + 1);
                } else {
                    hmap.put(sum, 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -(C[i] + D[j]);
                if (hmap.containsKey(sum)) {
                    count = count +hmap.get(sum);
                }

            }
        }

        return count;
    }

}
