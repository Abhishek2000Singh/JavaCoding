package Part11A_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Pq8_DetectCycle_UsingBFS_DFS {
  /*  static class Pair{
        int first;
        int second;


        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public  static boolean checkForCycle (int src, int V, ArrayList<ArrayList<Integer>>adj, boolean[] vis){
       vis[src]= true;
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(src,-1));
       while (!q.isEmpty()){
           int node = q.peek().first;
           int parent = q.peek().second;
           q.remove();

           for(int adjacentNode : adj.get(node)){
               if (vis[adjacentNode]==false){
                   vis[adjacentNode]=true;
                   q.add(new Pair(adjacentNode,node));
               } else if (parent!= adjacentNode) {
                   return true;
               }
           }
       }
       return false;
   }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        int parent[] = new int[V];
        Arrays.fill(parent,-1);

        for(int i=0;i<V;i++)
            if(vis[i]==false)
                if(checkForCycle(i,V,adj, vis))
                    return true;

        return false;
    }
*/
    private static boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>>adj){
        vis[node] = 1;
        for(int adjacentNode: adj.get(node)){
            if (vis[adjacentNode]==0){
                if (dfs(adjacentNode,node,vis,adj)==true){
                    return true;
                }
            }
            else if (adjacentNode != parent){
                return true;
            }
        }
        return false;
    }
    private static boolean isCycle(int V, ArrayList<ArrayList<Integer>>adj){
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i]==0){
                if (dfs(i,-1,vis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1);
        adj.get(1).add(3);



        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
