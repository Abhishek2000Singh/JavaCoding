package Part11A_Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Pq12_NumberOfIsland {
    public static void main(String[] args) {
        int [][] grid =  {
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0}
        };

        Pq12_NumberOfIsland obj = new Pq12_NumberOfIsland();
        System.out.println(obj.countDistinctIslands(grid));
    }

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }

    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = 1;
        vec.add((row - row0) + "," + (col - col0)); // Store the relative coordinates as a string
        int n = grid.length;
        int m = grid[0].length;

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, -1, 0, +1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, vec, row0, col0);
            }
        }
    }
}
