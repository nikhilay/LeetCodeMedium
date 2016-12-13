/**
 * Created by Nikhil on 12/12/16.
 */

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/59646/straightforward-java-solution-using-stack/2
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int numLength = num.length();
        if (k == numLength) {
            return "0";
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c ) {
                stack.pop();
                k--;

            }
            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
