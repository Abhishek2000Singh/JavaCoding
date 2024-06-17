package Part2A_RecursionStriverr;

import java.util.List;

public class Pq13_MColoring {
    private static boolean isSafe(int node, List<Integer>[] G,int[] color, int n, int col){
        for (int it:G[node]){
            if (color[it]==col)return false;
        }
        return true;
    }
    private static boolean solve(int node, List<Integer>[]G, int []color, int n, int m){
        if (node==n)return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G,color,n,i)){
                color[node] = i;
                if (solve(node+1, G, color, n, m)==true){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean graphColoring(List<Integer>[]G, int []color, int i, int m){
        int n = G.length;

        if (solve(0,G, color, n ,m)==true)return true;
        return false;
    }
    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        List<Integer>[] G = new List[4];
        G[0] = List.of(1, 2);
        G[1] = List.of(0, 2, 3);
        G[2] = List.of(0, 1, 3);
        G[3] = List.of(1, 2);

        // Number of colors
        int m = 2;

        // Array to store the color of each node
        int[] color = new int[G.length];

        // Check if the graph can be colored with m colors
        if (graphColoring(G, color, 0,m)) {
            System.out.println("Graph can be colored with " + m + " colors.");
            for (int i = 0; i < color.length; i++) {
                System.out.println("Node " + i + " -> Color " + color[i]);
            }
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors.");
        }
    }
}
