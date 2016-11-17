/**
 * Created by Nikhil on 11/17/16.
 */
/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }L
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return recursion(head, null);
    }

    private TreeNode recursion(ListNode start, ListNode end) {
        if(start==null){
            return null;
        } else if (start.next == end) {
            return new TreeNode(start.val);
        }
        ListNode slow = start;
        ListNode fast = start;
        while (fast != null && fast.next != null && fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = recursion(start, slow);
        start = slow.next==end?null:slow.next;
        root.right = recursion(start, end);
        return root;
    }


}
