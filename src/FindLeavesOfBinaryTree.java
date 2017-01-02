/**
 * Created by Nikhil on 10/24/16.
 */
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
 * Example:
 * Given binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Returns [4, 5, 3], [2], [1].
 * Explanation:
 * 1. Remove the leaves [4, 5, 3] from the tree
 * 1
 * /
 * 2
 * 2. Remove the leaf [2] from the tree
 * 1
 * 3. Remove the leaf [1] from the tree
 * []
 * Returns [4, 5, 3], [2], [1].
 */
public class FindLeavesOfBinaryTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root==null)return result;
        findLeavesAndRemove(result, root);
        return result;
    }

    private int findLeavesAndRemove(List<List<Integer>> result, TreeNode root) {
        if (root == null) return -1;
        int leftResult = findLeavesAndRemove(result, root.left);
        int rightResult = findLeavesAndRemove(result, root.right);

        int level =1+ Math.max(leftResult, rightResult);
        if(result.size()<level+1) result.add(new LinkedList<Integer>());
        root.left = null;
        root.right = null;
        result.get(level).add(root.val);
        return level;
    }
}
