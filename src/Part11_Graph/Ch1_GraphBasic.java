package Part11_Graph;

import java.util.ArrayList;

public class Ch1_GraphBasic {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        //creating epmty arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));


    }

    public static void main(String[] args) {
        int V = 4; // considering small graph

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        // print 2's neighbour
        for (int i = 0; i < graph[3].size(); i++) {
            Edge e = graph[3].get(i);
            System.out.print(e.dest + " ");
            // System.out.print(e.src + " ");
        }
        System.out.println();

        Edge e = graph[2].get(0);
        System.out.print(e.dest+ " ");
    }
}
