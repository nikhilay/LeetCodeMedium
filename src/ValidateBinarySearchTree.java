/**
 * Created by Nikhil on 12/14/16.
 */

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/7179/my-simple-java-solution-in-3-lines
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root,Long min,Long max){
        if(root ==null) return true;

        if(root.val<=min || root.val>=max) return false;
        return isValidBST(root.left,min,(long)root.val) && isValidBST(root.right,(long)root.val,max);

    }
}
