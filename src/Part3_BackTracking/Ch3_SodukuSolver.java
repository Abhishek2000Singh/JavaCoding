package Part3_BackTracking;

public class Ch3_SodukuSolver {

    public boolean isSafe(char[][] board, int row, int col, int number) {
        // row & col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }

        }

        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean helper(char[][] board, int row, int col) {
        int nrow = 0;
        int ncol = 0;

        if (row == board.length) {
            return true;
        }

        if (col != board.length - 1) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        if (board[row][col] != '0') {
            return helper(board, nrow, ncol);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, nrow, ncol)) {
                        return true;
                    } else {
                        board[row][col] = '0';
                    }
                }
            }
        }
        return false;
    }

    public boolean solveSudoku(char[][] board) {
        return helper(board, 0, 0);
    }

    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char board[][] = { { '3', '0', '6', '5', '0', '8', '4', '0', '0' },
                { '5', '2', '0', '0', '0', '0', '0', '0', '0' },
                { '0', '8', '7', '0', '0', '0', '0', '3', '1' },
                { '0', '0', '3', '0', '1', '0', '0', '8', '0' },
                { '9', '0', '0', '8', '6', '3', '0', '0', '5' },
                { '0', '5', '0', '0', '9', '0', '6', '0', '0' },
                { '1', '3', '0', '0', '0', '0', '2', '5', '0' },
                { '0', '0', '0', '0', '0', '0', '0', '7', '4' },
                { '0', '0', '5', '2', '0', '6', '3', '0', '0' } };

        Ch3_SodukuSolver solver = new Ch3_SodukuSolver();

        if (solver.solveSudoku(board))
            solver.print(board);
        else
            System.out.println("No solution exists");
    }
}
