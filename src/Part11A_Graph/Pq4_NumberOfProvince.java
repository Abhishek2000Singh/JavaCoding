package Part11A_Graph;

import java.util.ArrayList;

public class Pq4_NumberOfProvince {
    public static void dfs(int node, ArrayList<ArrayList<Integer>>adjLs, int []vis){
        vis[node] = 1;
        for (Integer it: adjLs.get(node)){
            if (vis[it]==0){
                dfs(it, adjLs, vis);
            }
        }
    }
    public static int numProvinces(ArrayList<ArrayList<Integer>>adj, int V){
        ArrayList<ArrayList<Integer>>adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        //to change adjacency matrix to list
        for (int i = 0; i < V ; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j)==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int vis[] = new int[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i]==0){
                cnt++;
                dfs(i,adjLs,vis);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {

    }
}
