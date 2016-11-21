/**
 * Created by Nikhil on 11/20/16.
 */

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
//Inspired from https://discuss.leetcode.com/topic/41110/java-solution-better-than-98-of-solutions/2
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode even = head.next;
        ListNode odd = head;
        ListNode p1 = head.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next =p1;
        return head;

    }

    public ListNode oddEvenListSolutionOne(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode even =new  ListNode(0);
        ListNode odd = new ListNode(0);
        ListNode p1 = even;
        ListNode p2 = odd;
        boolean isItOdd = true;

        while(head!=null){
            if(isItOdd){
                odd.next = head;
                odd = odd.next;
            }else {
                even.next = head;
                even = even.next;
            }
            isItOdd =!isItOdd;
            head = head.next;
        }
        even.next = p2.next;
        return p1.next;

    }
}
