/**
 * Created by Nikhil on 11/18/16.
 */

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/31115/using-hashmap-bfs-java-solutionB
 */
public class BinaryTreeVerticalOrderTraversal {
    public void verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return;
        HashMap<Integer,ArrayList<Integer>> hmap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min =0;
        HashMap<TreeNode, Integer> weight = new HashMap<>();
        weight.put(root,0);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if(!hmap.containsKey(w)){
                hmap.put(w, new ArrayList<Integer>());
            }
            hmap.get(w).add(node.val);
            if(root.left!=null){
                queue.add(node.left);
                weight.put(node.left,w-1);
            }
            if(root.right!=null){
                queue.add(node.right);
                weight.put(node.right,w+1);
            }
            min = Math.min(min, w);
        }
     while(hmap.containsKey(min)){
         res.add(hmap.get(min++));
     }
    }
}
