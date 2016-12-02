/**
 * Created by Nikhil on 12/2/16.
 */

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode f = head.next.next;
        ListNode s = head;
        while (f != null && f.next != null) {
            f = f.next;
            s = s.next;
        }
        ListNode list2 = s.next;
        s.next = null;
        return merge(sortList(head), sortList(list2));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode temp = new ListNode(0);
        ListNode mergedList = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return mergedList.next;
    }

}
