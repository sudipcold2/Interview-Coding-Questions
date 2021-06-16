package questions.medium;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
 * by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1)
 * or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously. Given the current state of the m x n grid board,
 * return the next state.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 *
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 *
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches upon
 * the border of the array (i.e., live cells reach the border). How would you address these problems?
 */
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
