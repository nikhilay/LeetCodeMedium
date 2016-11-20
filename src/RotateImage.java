/**
 * Created by Nikhil on 11/19/16.
 */

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        /**
         * Transposing matrix
         */
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        /**
         * flipping on col's to get clockwise
         */
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < (matrix[0].length / 2); col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix.length - 1 - col];
                matrix[row][matrix.length - 1 - col] = temp;
            }
        }


    }
}
