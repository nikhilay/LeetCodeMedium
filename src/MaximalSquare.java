/**
 * Created by Nikhil on 11/30/16.
 */


/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */

/**
 * https://discuss.leetcode.com/topic/20801/extremely-simple-java-solution/2
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows + 1][cols + 1];
        int result = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    memo[i][j] = Math.min(Math.min(memo[i][j - 1], memo[i - 1][j - 1]), memo[i - 1][j]) + 1;
                    result = Math.max(memo[i][j], result);
                }
            }
        }

        return result * result;
    }

}
