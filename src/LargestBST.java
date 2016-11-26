/**
 * Created by Nikhil on 11/26/16.
 */
/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 * 10
 * / \
 * 5  15
 * / \   \
 * 1 8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/36995/share-my-o-n-java-code-with-brief-explanation-and-comments
 */
public class LargestBST {

    class Wrapper{
        int size;
        int lower;
        int higher;

        Wrapper(int size, int lower, int higher){
            this.size =size;
            this.higher = higher;
            this.lower = lower;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        int[] max = {0};
        traverse(root,max);
        return max[0];
    }

    private Wrapper traverse(TreeNode root,int[] max){
        if(root==null){
            return new Wrapper(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Wrapper left = traverse(root.left,max);
        Wrapper right = traverse(root.right,max);
        if(left.size==-1|| right.size==-1||left.higher>root.val ||right.lower<root.val){
            return new Wrapper(-1,0,0);
        }
        int size = left.size+right.size+1;
        max[0] = Math.max(max[0],size);
        return new Wrapper(size,Math.min(left.lower, root.val),Math.max(root.val,right.higher));
    }

}
