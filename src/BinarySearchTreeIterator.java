/**
 * Created by Nikhil on 11/2/16.
 */

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

/**
 * Solution
 * https://discuss.leetcode.com/topic/6575/my-solutions-in-3-languages-with-stack
 */
public class BinarySearchTreeIterator {
    /**
     * Definition for binary tree
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushInStack(root);
    }


    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if(stack.isEmpty()) return -1;
        TreeNode focusNode = stack.pop();
        pushInStack(focusNode.right);
        return focusNode.val;

    }
    private void pushInStack(TreeNode root){
        while(root!=null){
            stack.push(root);
            root =root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */