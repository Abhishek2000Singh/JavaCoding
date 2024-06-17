package Part11_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pq1_AllPathFromSrc_toDes {
     static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        // creating epmty arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start ) {
        Queue<Integer> q = new LinkedList<>();
    
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;
                // finding and adding
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        if(vis[curr]) {
            return;
            }
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }
       
    }

    //O(V^V)
    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar)  
    {
       if (curr==tar) {
        System.out.println(path);
        return;
       }

       for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if (!vis[e.dest]) {
            vis[curr]=  true;
            printAllPath(graph, vis, e.dest, path+e.dest, tar);
            vis[curr]=false;
        }
       }
    }

    public static void main(String[] args) {
        int V = 7;
        /*
            1 --- 3
          |     |\
          0     | 5 -- 6
          \     | /
          2 ----4
         */
        ArrayList<Edge> graph[] = new ArrayList[V];
         boolean vis []= new boolean [V];
        createGraph(graph);
         
        int src = 0; int tar = 5;
        printAllPath(graph, vis, src, "0", tar);

    }
}
