import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhil on 11/16/16.
 */

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 */
public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        helper(root, result, sum, new LinkedList<Integer>());
        return result;

    }

    private void helper(TreeNode root, List<List<Integer>> result, int target, List<Integer> list) {
        if (root == null) return;
        if (target == root.val && (root.left == null && root.right == null)) {
            List<Integer> paths = new LinkedList<>(list);
            paths.add(root.val);
            result.add(paths);
            return;
        } else if (target != root.val && (root.left == null && root.right == null)) {
            return;
        }

        List temp = new LinkedList<>();
        temp.addAll(list);
        temp.add(root.val);
        helper(root.left, result, target - root.val, temp);
        helper(root.right, result, target - root.val, temp);
    }
}
