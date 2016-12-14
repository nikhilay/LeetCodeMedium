/**
 * Created by Nikhil on 12/13/16.
 */

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReOrderList {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev =null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;


        //Now reverse second half
        ListNode l2 = reverse(slow);
        while(l2!=null){
            System.out.println(l2.val);
            l2 =l2.next;
        }

        mergelist(head, l2);
    }

    private void mergelist(ListNode list1, ListNode list2) {
        while (list1 != null) {
            ListNode temp1 = list1;
            list1 = list1.next;
            ListNode temp2 = list2;
            list2 = list2.next;
            temp1.next = temp2;
            if (list1 == null) {
                break;
            }
            temp2.next = list1;



        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            head = head.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        return prev;
    }
}
