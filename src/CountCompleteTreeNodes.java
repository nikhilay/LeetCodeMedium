/**
 * Created by Nikhil on 11/22/16.
 */

/**
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the
 * last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/21317/accepted-easy-understand-java-solution/2
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHt = leftHeight(root);
        int rightHt = rightHeight(root);

        if (leftHt == rightHt) {
            return (1 << leftHt) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftHeight(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    private int rightHeight(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }
}
