import java.util.HashSet;

/**
 * Created by Nikhil on 11/17/16.
 */

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
 * Can you solve it without using extra space?
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation
 */
public class LinkedListCycleTwo {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //With Extra space
    public ListNode detectCycleWithExtraSpace(ListNode head) {
        if (head == null) return null;
        HashSet<ListNode> hset = new HashSet<>();
        while (head != null) {
            if (!hset.contains(head)) {
                hset.add(head);
            } else {
                return head;
            }
            head = head.next;
        }

        return null;
    }

    //Without Extra space
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow ==fast){
                ListNode temp = head;
                while(slow!=temp){
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow;
            }

        }
        return null;
    }

}
