package Part11_Graph;

import java.util.ArrayList;

public class Pq2_CycleDetection {
     static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d){
            this.src =s;
            this.dest = d;
            // this.wt = w;
        }
    }

     public static void createGraph(ArrayList<Edge> graph[]) {

        //creating epmty arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 3));
        // graph[2].add(new Edge(2, 0));
        // graph[1].add(new Edge(1, 2));
        // graph[3].add(new Edge(3, 4));
        // graph[4].add(new Edge(4, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    
    }
// O(V+E)
    public static boolean isCycleDirected(ArrayList<Edge>graph[] , boolean vis[], int curr, boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) {//cycle detection
                return true;
            }else if (!vis[e.dest]) {
              if (isCycleDirected(graph, vis, e.dest, rec)){
                return true;
              }
            }
        }
        rec[curr]= false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4; // considering small graph
       
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean vis []= new boolean [V];
        boolean rec []= new boolean [V];
        
        //for the graph  directed graph which are not connected
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                // System.out.println(isCycleDirected(graph,vis,0,rec )); for getting multiple cycle

                boolean isCycle = isCycleDirected(graph,vis,0,rec) ;
                if (isCycle) {
                    System.out.println(isCycle);
                    break;
                }
            }
        }
        
    }
}
