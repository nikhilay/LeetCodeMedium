/**
 * Created by Nikhil on 1/2/17.
 */

import java.util.Stack;

/**
 * You are given two linked lists representing two non-negative numbers. The most significant digit comes first and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

public class AddTwoNumbersTwo {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int first = stack1.isEmpty() ? 0 : stack1.pop();
            int second = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = first + second + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode head = new ListNode(digit);
            head.next = res;
            res = head;

        }
        if (carry != 0) {
            ListNode head = new ListNode(carry);
            head.next = res;
            res = head;
        }

        return res;
    }
}
