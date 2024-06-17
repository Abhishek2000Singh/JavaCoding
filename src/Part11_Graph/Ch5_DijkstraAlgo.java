package Part11_Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Ch5_DijkstraAlgo {
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

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist=d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist; //for ascending order
            //return p2.dist - this.dist for descending order
            /*if it return (-ve) then p2 > this
             * = 0 then both are equal
             * +ve then this > p2
             */
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src, int V){

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));

        //bfs

        while (!pq.isEmpty()) {
            Pair curr = pq.remove(); //shortest
            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v= e.dest;
                    if (dist[u]+e.wt < dist[v]) { //relaxation
                        dist[v] =dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        //printing all the numbers
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        int src = 0;
        dijkstra(graph, 0,V);
       
        
        }
}
