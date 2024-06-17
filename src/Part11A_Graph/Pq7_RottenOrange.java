package Part11A_Graph;
/*
* Problem Statement: You will be given an m x n grid, where each cell has the following values :

2  -  represents a rotten orange
1  -  represents a Fresh orange
0  -  represents an Empty Cell
Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction ( upward, downwards, right, and left ) it becomes Rotten.

Return the minimum number of minutes required such that none of
the cells has a Fresh Orange. If it's not possible, return -1.*/
import java.util.*;


public class Pq7_RottenOrange {
    static class Pair{
        int row;
        int col;
        int tm;

        Pair(int row, int col, int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public static int orangesRotting(int [][]grid){
        if (grid==null ||grid.length==0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int [][]vis = new int[n][m];
        int cntfresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if (grid[i][j]==1)cntfresh++;
            }
        }

        int tm = 0;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        int cnt=0;
        while (!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(t,tm);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if (nrow>=0 && nrow<n && ncol>= 0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol, t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if (cnt != cntfresh) return -1;
        return tm;
    }
    public static void main(String[] args) {
        int arr[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
}
