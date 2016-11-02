/**
 * Created by Nikhil on 11/2/16.
 */

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections
 * . The longest consecutive path need to be from parent to child (cannot be the reverse).
 * For example,
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConscutiveSequence {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public int longestConsecutiveSequence(TreeNode root) {
        if (root == null) return 0;
        int curr = 0;
        helper(root, curr, root.val);
        return max;
    }
    private void helper(TreeNode root, int curr, int target){
        if(root==null) return;
        curr = root.val==target?curr+1:1;
        max= Math.max(max,curr);
        helper(root.left, curr, target+1);
        helper(root.right, curr, target+1);
    }
}
