import java.util.HashMap;

/**
 * Created by Nikhil on 12/27/16.
 */

/**
 *Given inorder and postorder traversal of a tree, construct the binary tree.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/3296/my-recursive-java-code-with-o-n-time-and-o-n-space
 */
public class ConstructBinaryTreefromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        int is = 0;
        int ie = inorder.length - 1;
        int ps = 0;
        int pe = postorder.length - 1;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        return buildTree(inorder, is, ie, postorder, ps, pe, hmap);
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> hmap) {
        if (is > ie || ps > pe) return null;
        int ri = hmap.get(postorder[pe]);
        TreeNode root = new TreeNode(inorder[ri]);
        root.left = buildTree(inorder, is, ri - 1, postorder, ps, ps + ri - 1 - is, hmap);
        root.right = buildTree(inorder, ri + 1, ie, postorder, ps + ri - is, pe - 1, hmap);
        return root;
    }
}
