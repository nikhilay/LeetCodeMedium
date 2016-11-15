import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhil on 11/14/16.
 */
public class BinaryTreeZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
        if (result.size() <= level) {
            List<Integer> list = new LinkedList<>();
            result.add(level, list);
        }

        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
