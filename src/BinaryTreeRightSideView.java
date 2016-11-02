/**
 * Created by Nikhil on 11/2/16.
 */

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/11768/my-simple-accepted-solution-java
 */
public class BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null) return result;
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int currDepth){
        if(root==null) return;

        if(result.size()==currDepth){
            result.add(root.val);
        }

        helper(root.right, result, currDepth +1);
        helper(root.left, result, currDepth +1);
    }
}
