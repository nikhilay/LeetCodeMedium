/**
 * Created by Nikhil on 12/27/16.C
 */

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */

import java.util.HashMap;
public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || preorder.length == 0) return null;
        int is =0 ;
        int ie = inorder.length-1;
        int ps = 0;
        int pe = preorder.length-1;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hmap.put(inorder[i],i);
        }
        return buildTree(preorder,ps,pe,inorder,is,ie,hmap);
    }

    private TreeNode buildTree(int[] preorder, int ps,int pe, int[] inorder, int is, int ie, HashMap<Integer,Integer> hmap){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int ri = hmap.get(preorder[ps]);
        root.left =buildTree(preorder,ps+1,ps+ri,inorder,is,ri-1,hmap);
        root.right=buildTree(preorder,ps+ri+1-is,pe,inorder,ri+1,ie,hmap);
        return root;
    }
}
