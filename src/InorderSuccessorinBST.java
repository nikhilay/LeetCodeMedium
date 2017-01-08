/**
 * Created by Nikhil on 1/8/17.
 */

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 */

/**
 * https://discuss.leetcode.com/topic/25698/java-python-solution-o-h-time-and-o-1-space-iterative
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while(root!=null){
            if(p.val<root.val){
                succ = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return succ;
    }
}
