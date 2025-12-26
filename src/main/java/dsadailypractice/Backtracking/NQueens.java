package dsadailypractice.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backrack(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), res);
        return res;
    }

    public void backrack(char[][] board, int row, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag, List<List<String>> res) {
        if (row == board.length) {
            List<String> newBoard = new ArrayList<>();
            for (char[] ch : board) {
                newBoard.add(new String(ch));
            }
            res.add(newBoard);
        }
        for (int col = 0; col < board.length; col++) {
            if (cols.contains(col) || diag.contains(row - col) || antiDiag.contains(row + col))
                continue;
            board[row][col] = 'Q';
            cols.add(col);
            diag.add(row - col);
            antiDiag.add(row + col);
            backrack(board, row + 1, cols, diag, antiDiag, res);
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row - col);
            antiDiag.remove(row + col);
        }
    }
}
