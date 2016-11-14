/**
 * Created by Nikhil on 11/13/16.
 */

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int colLen = matrix[0].length;
        int rowLen = matrix.length;
        int start = 0;
        int end = colLen * rowLen - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int mid_Value = matrix[mid / colLen][mid % colLen];
            if (mid_Value == target) {
                return true;
            } else if (target > mid_Value ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
