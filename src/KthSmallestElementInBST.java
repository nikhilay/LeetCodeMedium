/**
 * Created by Nikhil on 10/30/16.
 */

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */

public class KthSmallestElementInBST {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        return recursiveKthSmallest(root, k);

    }

    public int recursiveKthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return recursiveKthSmallest(root.left, k);
        } else if (k > count + 1) {
            return recursiveKthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int countNodes(TreeNode focusNode) {
        if (focusNode == null) return 0;
        return 1 + countNodes(focusNode.left) + countNodes(focusNode.right);
    }
}
