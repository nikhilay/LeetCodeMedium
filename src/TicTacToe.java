/**
 * Created by Nikhil on 10/25/16.
 */

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */

public class TicTacToe {
    private int[][] matrix;
    private int gridSize;

    TicTacToe(int gridSize) {
        matrix = new int[gridSize][gridSize];
        this.gridSize = gridSize;
    }


    public int move(int row, int col, int player) {
        matrix[row][col] = player;

        boolean win = true;

        //checking for Row

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] != player) {
                win = false;
                break;
            }
        }

        if (win) return player;

        //Checking for column
        win = true;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[row][j] != player) {
                win = false;
                break;
            }
        }

        if (win) return player;

        //checking for forward Diagonal
        win = true;
        if (row - col == 0) {
            int indexRow = 0;
            int indexCol = 0;
            while (indexRow < gridSize && indexCol < gridSize) {
                if (matrix[indexRow][indexCol] != player) {
                    win = false;
                    break;
                }
                indexCol++;
                indexRow++;
            }
        }
        if (win) return player;

        //checking for Backward Diagonal
        win = true;
        if (row +col == (gridSize-1) ){
            int indexRow = 0;
            int indexCol = gridSize-1;
            while (indexRow < gridSize && indexCol < gridSize) {
                if (matrix[indexRow][indexCol] != player) {
                    win = false;
                    break;
                }
            }
            indexCol--;
            indexRow++;
        }
        if (win) return player;

     return 0;
    }
}

