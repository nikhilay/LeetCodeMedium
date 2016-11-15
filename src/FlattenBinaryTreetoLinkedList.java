/**
 * Created by Nikhil on 11/14/16.
 */

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class FlattenBinaryTreetoLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;

    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        helper(root.left);
        int val = helper(root.right);
        if(root.left!=null && (val==1)){
            TreeNode temp = root.right;
            root.right= root.left;
            TreeNode temp1 = root.right;
            while(temp1.right!=null){
                temp1 = temp1.right;
            }
            temp1.right = temp;
            root.left=null;
        }else if(root.left==null && (val==1)){
            root.left = root.right;
        }
        return 1;
    }
}
