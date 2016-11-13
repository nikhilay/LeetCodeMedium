/**
 * Created by Nikhil on 11/12/16.
 */

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using
 * the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        int[] rowIndex = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colIndex = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                int liveCell = 0;
                for (int i = 0; i < rowIndex.length; i++) {
                    int neighbourRow = row + rowIndex[i];
                    int neighbourCol = col + colIndex[i];
                    if ((neighbourRow >= 0 && neighbourRow < rowLen) && (neighbourCol >= 0 && neighbourCol < colLen) && (board[neighbourRow][neighbourCol] == 1 || board[neighbourRow][neighbourCol] == 2)) {
                        liveCell++;
                    }
                }

                if ((liveCell < 2 || liveCell > 3) && board[row][col] == 1) {
                    board[row][col] = 2;
                }
                if (liveCell == 3 && board[row][col] == 0) {
                    board[row][col] = 3;
                }

            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }

        }
    }
}
