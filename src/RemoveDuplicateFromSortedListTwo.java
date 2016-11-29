/**
 * Created by Nikhil on 11/28/16.
 */

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicateFromSortedListTwo {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode list = new ListNode(0);
        ListNode result = list;
        while (head != null && head.next != null) {
            ListNode temp = head;
            int val1 = head.val;
            head = head.next;
            int val2 = head.val;
            if (val1 != val2) {
                list.next = temp;
                list = list.next;
            } else {
                head = iterate(head, val2);
            }
        }
        list.next = head;
        return result.next;
    }

    private ListNode iterate(ListNode node, int duplicatedVal) {

        while (node != null && duplicatedVal == node.val) {
            node = node.next;
        }
        return node;
    }
}
