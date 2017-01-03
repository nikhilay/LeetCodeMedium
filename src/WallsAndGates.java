/**
 * Created by Nikhil on 1/3/17.
 */

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume
 * that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be
 * filled with INF.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms ==null || rooms.length==0 ||rooms[0].length==0) return;
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0) dfs(rooms,i,j,0);
            }
        }

    }
    private void dfs(int[][] rooms,int row,int col,int distance){
        if(row<0 || row>=rooms.length||col<0||col>=rooms[0].length||rooms[row][col]<distance||rooms[row][col]==-1) return;
        rooms[row][col]= distance;
        dfs(rooms,row-1,col,distance+1);
        dfs(rooms,row,col-1,distance+1);
        dfs(rooms,row+1,col,distance+1);
        dfs(rooms,row,col+1,distance+1);
    }
}
