/**
 * Created by Nikhil on 12/27/16.
 */

import java.util.*;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a
 * rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1]
 * is the same as [1, 0] and thus will not appear together in edges.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<HashSet<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int vertexA = edges[i][0];
            int vertexB = edges[i][1];
            adj.get(vertexA).add(vertexB);
            adj.get(vertexB).add(vertexA);
        }

        List<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }

        Iterator it = leaves.iterator();
        while (it.hasNext()) {
            res.add((int) it.next());
        }
        return res;
    }
}
