import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 11/25/16.
 */
public class UniqueBSTTwo {
    public List<TreeNode> generateTrees(int n) {
        return getTrees(1, n);

    }

    private List<TreeNode> getTrees(int start, int end) {
        List<TreeNode> result = new ArrayList();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {

            left = getTrees(start, i - 1);
            right = getTrees(i + 1, end);

            for (TreeNode nodeL : left) {
                for (TreeNode nodeR : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodeL;
                    root.right = nodeR;
                    result.add(root);
                }
            }
        }
        return result;

    }
}
