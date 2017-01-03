/**
 * Created by Nikhil on 1/3/17.
 */

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the
 * same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into
 * left leaf nodes. Return the new root.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/18273/clean-java-solution
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null || root.left==null) return root;
        TreeNode node = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left=null;
        root.right=null;
        return node;
    }
}
