/**
 * Created by Nikhil on 10/26/16.
 */

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) return Integer.MIN_VALUE;
        int low = matrix[0][0];
        int n = matrix.length;
        int high = matrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getCount(matrix, mid);
            if (count < k) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int getCount(int[][] matrix, int mid) {
        int result = 0;
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {

            if (matrix[i][j] > mid) {
                i--;
            } else {
                j++;
                result += i + 1;
            }

        }
        return result;
    }

}
