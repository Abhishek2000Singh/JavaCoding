package Part11A_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Pq9_Distance_OFNearestcell_Having1_0Or1 {
     static class Node {
        int first;
        int second;
        int third;
        Node(int _first, int _second, int _third) {
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }
    public static int [][] nearest(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int vis[][]= new int[n][m];
        int dist[][]= new int[n][m];

        //<coordinates,steps>
        Queue<Node> q = new LinkedList<>();

        //traverse the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //start bfs if cell contains 1
                if (mat[i][j]==1){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]= 0;
                }
            }
        }

        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};

        while (!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();

            dist[row][col] = steps; //storing the steps for dis matrix
            for (int i = 0; i < 4; i++) {
                int nrow = row+delRow[i];
                int ncol = col+delCol[i];

                if (nrow>=0 && nrow<n && ncol>= 0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol] =1;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };


        int[][] ans = nearest(mat);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}


