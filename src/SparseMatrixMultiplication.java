/**
 * Created by Nikhil on 10/29/16.
 */

/**
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] a, int[][] b) {
        if (a == null || b == null) return null;
        int[][] result = new int[a.length][b[0].length];

        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[0].length; col++) {
                if (a[row][col] != 0) {
                    for (int k = 0; k < b[0].length; k++) {
                        if (b[col][k]!=0){
                            result[row][k] += a[row][col] * b[col][k];
                        }
                    }
                }
            }
        }
        return result;
    }
}
