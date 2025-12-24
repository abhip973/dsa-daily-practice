package dsadailypractice.Backtracking;

public class WordSearch {
    int row, column, max;
    boolean res = false;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        column = board[0].length;
        max = word.length();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0))
                    backtrack(i, j, 1, word, board);
            }
        }
        return res;
    }

    public void backtrack(int i, int j, int nextPos, String word, char[][] board) {
        if (nextPos == max) {
            res = true;
            return;
        }
        char original = board[i][j];
        board[i][j] = '#';
        if (i - 1 >= 0 && board[i - 1][j] == word.charAt(nextPos))
            backtrack(i - 1, j, nextPos + 1, word, board);
        if (i + 1 < row && board[i + 1][j] == word.charAt(nextPos))
            backtrack(i + 1, j, nextPos + 1, word, board);
        if (j - 1 >= 0 && board[i][j - 1] == word.charAt(nextPos))
            backtrack(i, j - 1, nextPos + 1, word, board);
        if (j + 1 < column && board[i][j + 1] == word.charAt(nextPos))
            backtrack(i, j + 1, nextPos + 1, word, board);
        board[i][j] = original;
    }
}
