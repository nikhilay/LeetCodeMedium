/**
 * Created by Nikhil on 11/2/16.
 */

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum
 * enemies you can kill using one bomb. The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * Example:
 * For the given grid
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/48603/java-straightforward-solution-dp-o-mn-time-and-space
 */
public class BombEnemy {
    class Spot {
        int left;
        int right;
        int up;
        int down;
    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Spot[][] track = new Spot[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                track[i][j] = new Spot();
                if (grid[i][j] == 'W') continue;
                track[i][j].up = (i == 0 ? 0 : track[i - 1][j].up) + (grid[i][j] == 'E' ? 1 : 0);
                track[i][j].left = (j == 0 ? 0 : track[i][j - 1].left) + (grid[i][j] == 'E' ? 1 : 0);
            }
        }

        int res = 0;

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') continue;
                track[i][j].down = (i == rows - 1 ? 0 : track[i + 1][j].down) + (grid[i][j] == 'E' ? 1 : 0);
                track[i][j].right = (j == cols - 1 ? 0 : track[i][j + 1].right) + (grid[i][j] == 'E' ? 1 : 0);

                if (grid[i][j] == '0') {
                    res = Math.max(res, track[i][j].left + track[i][j].up + track[i][j].right + track[i][j].down);
                }

            }
        }

        return res;
    }

}
