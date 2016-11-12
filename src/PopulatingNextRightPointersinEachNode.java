/**
 * Created by Nikhil on 11/11/16.
 */

/**
 * Given a binary tree
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/12241/my-recursive-solution-java/2
 */
public class PopulatingNextRightPointersinEachNode {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }

        if(root.left!=null){
            root.left.next = root.right;
        }
        if(root.next!=null && root.right!=null){
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
