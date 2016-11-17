/**
 * Created by Nikhil on 11/17/16.
 */

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode sortedListHead = head;
        while (head != null) {
            ListNode dummy = sortedListHead;
            while (head != dummy) {
                if (head.val < dummy.val) {
                    int temp = dummy.val;
                    dummy.val = head.val;
                    head.val = temp;
                }
                dummy = dummy.next;
            }
            head = head.next;
        }


        return sortedListHead;

    }
}
