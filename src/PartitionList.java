/**
 * Created by Nikhil on 11/17/16.
 */

/**
 * Given a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode head1 = list1;
        ListNode head2 = list2;


        while (head != null) {
            if (head.val < x) {
                list1.next = head;
                list1 = list1.next;
            } else {
                list2.next = head;
                list2 = list2.next;
            }
            head = head.next;
        }
        list2.next = null;
        list1.next = head2.next;
        return head1.next;
    }
}
