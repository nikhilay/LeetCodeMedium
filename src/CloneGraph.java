import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nikhil on 12/13/16.
 */

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {
    // Definition for undirected graph.
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    ;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        HashMap<Integer, UndirectedGraphNode> hmap = new HashMap<>();
        return clone(node, hmap);

    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> hmap) {

        if (node == null) return null;
        if (hmap.containsKey(node.label)) {
            return hmap.get(node.label);
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        hmap.put(newNode.label, newNode);

        for (UndirectedGraphNode neighbour : node.neighbors) {
            newNode.neighbors.add(clone(neighbour, hmap));
        }
        return newNode;

    }
}
