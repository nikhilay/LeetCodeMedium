/**
 * Created by Nikhil on 10/24/16.
 */

/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.Ò
 */

public class PlusOneLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        int carry = recursivleyAdd(head);
        helper.val= carry;
        return helper.val == 0 ? helper.next : helper;
    }

    private int recursivleyAdd(ListNode focusNode) {
        int carry = 0;
        int sum = 0;
        int digit = 0;
        if (focusNode.next == null) {
            sum = focusNode.val + 1;
            digit = sum % 10;
            carry = sum / 10;
            focusNode.val = digit;
            return carry;
        }

        carry = recursivleyAdd(focusNode.next);
        sum = carry + focusNode.val;
        digit = sum % 10;
        focusNode.val = digit;
        carry = sum / 10;
        return carry;


    }
}
