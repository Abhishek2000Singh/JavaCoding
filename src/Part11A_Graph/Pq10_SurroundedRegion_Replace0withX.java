package Part11A_Graph;

public class Pq10_SurroundedRegion_Replace0withX {
    static void dfs(int row, int col, int vis[][],
                    char board[][], int delrow[], int delcol[]) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        // check for top, right, bottom, left
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            // check for valid coordinates and unvisited Os
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board, delrow, delcol);
            }
        }
    }

    static char[][] fill(int n, int m, char board[][]) {
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};
        int vis[][] = new int[n][m];
        // traverse first row and last row
        for (int j = 0; j < m; j++) {
            // check for unvisited Os in the boundary rws
            // first row
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, delrow, delcol);
            }

            // last row
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board, delrow, delcol);
            }
        }

        for (int i = 0; i < n; i++) {
            // check for unvisited Os in the boundary columns
            // first column
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, delrow, delcol);
            }

            // last column
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board, delrow, delcol);
            }
        }

        // if unvisited O then convert to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        return board;
    }

    public static void main(String[] args) {
        char board[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4

        char[][] ans = fill(5, 4, board);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
