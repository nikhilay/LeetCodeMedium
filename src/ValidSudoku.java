/**
 * Created by Nikhil on 1/22/17.
 */

import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/9748/shared-my-concise-java-code/2
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0) return false;
        for(int i=0;i<9;i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j])) return false;
                if(board[j][i]!='.' && !cols.add(board[j][i])) return false;
                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                if(board[rowIndex+j/3][colIndex + j%3]!='.' && !cube.add(board[rowIndex+j/3][colIndex + j%3])) return false;


            }

        }
        return true;
    }
}
