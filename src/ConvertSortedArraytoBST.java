/**
 * Created by Nikhil on 10/31/16.
 */

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums == null || nums.length == 0) return root;
        int start = 0;
        int end = nums.length - 1;
        return helper(nums, start, end);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);
        return node;
    }
}

