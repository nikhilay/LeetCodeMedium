import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Nikhil on 12/25/16.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) return true;
        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hmap.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            hmap.get(edges[i][0]).add(edges[i][1]);
            hmap.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        boolean disconnected= false;
        for (int vertex = 0; vertex < n; vertex++) {
            if (visited.add(vertex)) {
                if(disconnected) return false;
                if(!dfs(vertex,0,hmap, visited) ){
                    return false;
                }
                disconnected = true;

            }
        }
        return true;
    }

    private boolean dfs(int vertex,int parent, HashMap<Integer, ArrayList<Integer>> hmap, HashSet<Integer> visited) {
        for(int i:hmap.get(vertex)){
            if (visited.add(i)) {
                dfs(i,vertex,hmap, visited);
            }else if(parent!=i){
                return false;
            }
        }
        return true;

    }
}
