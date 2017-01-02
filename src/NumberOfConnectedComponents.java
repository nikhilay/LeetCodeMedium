/**
 * Created by Nikhil on 10/25/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static javax.swing.UIManager.get;


/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * Example 1:
 * 0 3
 * | |
 * 1 --- 2 4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 */
public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;
        HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hmap.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            hmap.get(edges[i][0]).add(edges[i][1]);
            hmap.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for (int vertex = 0; vertex < n; vertex++) {
            if (visited.add(vertex)) {
                dfs(vertex,hmap, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int vertex, HashMap<Integer, ArrayList<Integer>> hmap, HashSet<Integer> visited) {
       for(int i:hmap.get(vertex)){
           if (visited.add(i)) {
               dfs(i,hmap, visited);
           }
       }

    }
}
