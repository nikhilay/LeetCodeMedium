/**
 * Created by Nikhil on 12/22/16.
 */

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
public class DeleteANodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }else if(key<root.val){
            return deleteNode(root.left,key);
        }else if(key>root.val){
            return deleteNode(root.right,key);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            root.val = findMin(root);
            root.right = deleteNode(root.right,root.val);
        }
        return root;

    }

    private int findMin(TreeNode node){

        while(node.left!=null){
            node = node.left;
        }
        return node.val;

    }
}
