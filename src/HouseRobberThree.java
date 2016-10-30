/**
 * Created by Nikhil on 10/30/16.
 */

import java.util.HashMap;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses
 * in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */


public class HouseRobberThree {

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        HashMap<TreeNode, Integer> hmap = new HashMap<>();
        return recursiveRob(root, hmap);
    }

    private int recursiveRob(TreeNode root, HashMap<TreeNode, Integer> hmap) {
        if (root == null) return 0;
        if (hmap.containsKey(root)) return hmap.get(root);
        int sum = 0;
        if (root.left != null) {
            sum += recursiveRob(root.left.left, hmap) + recursiveRob(root.left.right, hmap);
        }
        if (root.right != null) {
            sum += recursiveRob(root.right.right, hmap) + recursiveRob(root.right.left, hmap);
        }
        return Math.max(sum + root.val, recursiveRob(root.left, hmap) + recursiveRob(root.right, hmap));

    }

    public int efficientrob(TreeNode root) {
        if (root == null) return 0;
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    private int[] helper(TreeNode root) {
        if(root==null){
            return new int[2];
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] result = new int[2];
        result[0]=root.val+left[1]+right[1];
        result[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return result;

    }
}
