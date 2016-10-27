/**
 * Created by Nikhil on 10/26/16.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInOrderIteratively {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left != null) {
                stack.push(temp.left);
                temp.left = null;
            } else {
                list.add(temp.val);
                stack.pop();
                if (temp.right != null) {
                    stack.push(temp.right);
                }
            }

        }
        return list;

    }
}
