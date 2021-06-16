package questions.medium;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is
 * not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected
 * if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 3 || board[0].length < 3)
            return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O')
                helper(board, i, 0);

            if (board[i][n - 1] == 'O')
                helper(board, i, n - 1);
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O')
                helper(board, 0, j);

            if (board[m - 1][j] == 'O')
                helper(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O')
            return;

        board[r][c] = '*';

        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }
}
