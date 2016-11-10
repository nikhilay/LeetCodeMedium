/**
 * Created by Nikhil on 11/10/16.
 */

/**
 * Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                if (j == 0 && i != 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if (i != 0 && j != 0) {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[row - 1][col - 1];

    }
}
