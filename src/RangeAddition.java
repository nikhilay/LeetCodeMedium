/**
 * Created by Nikhil on 10/24/16.
 */

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex]
 * (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 * Example:
 * Given:
 * length = 5,
 * updates = [
 * [1,  3,  2],
 * [2,  4,  3],
 * [0,  2, -2]
 * ]
 * Output:
 * [-2, 0, 3, 5, 3]
 */

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for (int[] operation : updates) {
            int start = operation[0];
            int end = operation[1];
            int increment = operation[2];

            result[start] += increment;

            if (end < length - 1) {
                result[end] -= increment;
            }
        }
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}
