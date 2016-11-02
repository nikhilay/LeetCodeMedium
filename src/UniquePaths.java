/**
 * Created by Nikhil on 11/2/16.
 */

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?Ò
 */
public class UniquePaths {
    public static void main(String[] args) {
        new UniquePaths().uniquePaths(1, 2);
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return backtracker(m - 1, n - 1, memo);
    }

    private int backtracker(int row, int col, int[][] memo) {
        if (row == 0 && col == 0) {
            memo[row][col] = 1;
            return 1;
        }
        if (row < 0 || col < 0) {
            return -1;
        }
        if (memo[row][col] < 0) {
            return -1;
        } else if (memo[row][col] > 0) {
            return memo[row][col];
        }
        int upSide = backtracker(row - 1, col, memo);
        int leftSide = backtracker(row, col - 1, memo);

        if (upSide < 0 && leftSide < 0) {
            memo[row][col] = -1;
            return -1;
        }
        leftSide = leftSide > 0 ? leftSide : 0;
        upSide = upSide > 0 ? upSide : 0;
        memo[row][col] = leftSide + upSide;
        return memo[row][col];
    }
}
