/**
 * Created by Nikhil on 12/13/16.
 */

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] input ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        new WordSearch().exist(input,"ABCCED");
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.charAt(0) == board[row][col] && search(board, visited, word, 1, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                word.charAt(index) != board[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (search(board, visited, word, index + 1, row + 1, col) ||
                search(board, visited, word, index + 1, row - 1, col) ||
                search(board, visited, word, index + 1, row, col + 1) ||
                search(board, visited, word, index + 1, row, col - 1)) {
            return true;
        }
        visited[row][col] = false;
        return false;

    }
}
