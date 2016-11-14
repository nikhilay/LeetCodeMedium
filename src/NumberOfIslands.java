/**
 * Created by Nikhil on 11/13/16.
 */

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null ||grid.length==0||grid[0].length==0) return 0;
        int countIslands =0;
        for(int row =0;row<grid.length;row++){
            for(int col =0;col<grid[0].length;col++){
                if(grid[row][col]=='1'){
                    countIslands++;
                    dfs(grid,row,col);
                }
                continue;
            }
        }
        return countIslands;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row<0 ||row>=grid.length ||col<0 ||col>=grid[0].length || grid[row][col]!='1') return;
        grid[row][col] = '2';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
