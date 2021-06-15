package questions.medium;

public class GameOfLife {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1, -1}, {-1, 1}, {1, -1}};
    private static final int ALIVE = 1;
    private static final int DEAD = 0;
    private static final int DEADTOALIVE = 2;
    private static final int ALIVETODEAD = 3;

    public void gameOfLife(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {

                int alive = 0;

                for (int[] direction : directions) {
                    alive += isAlive(board, r + direction[0], c + direction[1]) ? 1 : 0;
                }

                // in case current cell is dead but has 3 live neighbors
                if (board[r][c] == DEAD) {
                    if (alive == 3) {
                        board[r][c] = DEADTOALIVE;
                    }
                }
                else {
                    if (alive != 2 && alive != 3) {
                        board[r][c] = ALIVETODEAD;
                    }
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == DEADTOALIVE) {
                    board[r][c] = ALIVE;
                }
                else if (board[r][c] == ALIVETODEAD) {
                    board[r][c] = DEAD;
                }
            }
        }
    }

    private boolean isAlive(int[][] board, int r, int c) {
        return r >= 0 &&
                r < board.length &&
                c >= 0 &&
                c < board[0].length &&
                (board[r][c] == ALIVE || board[r][c] == ALIVETODEAD);
    }
}
