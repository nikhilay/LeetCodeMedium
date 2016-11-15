/**
 * Created by Nikhil on 11/14/16.
 */

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return sum;

    }

    private void helper(TreeNode root, int previousSum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum = sum + root.val + previousSum * 10;
            return;
        }
        helper(root.left, root.val + previousSum * 10);
        helper(root.right, root.val + previousSum * 10);
    }
}
