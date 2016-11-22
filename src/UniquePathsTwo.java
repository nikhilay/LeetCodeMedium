/**
 * Created by Nikhil on 11/21/16.
 */

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 */
public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        for (int row = 0; row < obstacleGrid.length; row++) {
            for (int col = 0; col < obstacleGrid[0].length; col++) {
                if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                } else if (row == 0 && col == 0) {
                    obstacleGrid[row][col] = 1;
                } else if (row == 0) {
                    obstacleGrid[row][col] = obstacleGrid[row][col - 1];
                } else if (col == 0) {
                    obstacleGrid[row][col] = obstacleGrid[row - 1][col];
                } else {
                    obstacleGrid[row][col] = obstacleGrid[row - 1][col] + obstacleGrid[row][col - 1];
                }

            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
