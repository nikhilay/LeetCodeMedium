/**
 * Created by Nikhil on 12/14/16.
 */

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {
    // Definition for singly-linked list.
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        int len = 1;
        while(curr.next!=null){
            curr = curr.next;
            len++;
        }
        k = k%len;
        int shift = len-k;
        if(k==0||shift==0){
            return head;
        }
        ListNode traverse = head;
        ListNode prev =null;
        while(shift!=0){
            prev = traverse;
            traverse =traverse.next;
            shift--;
        }
        prev.next = null;
        curr.next =head;
        return traverse;

    }
}
