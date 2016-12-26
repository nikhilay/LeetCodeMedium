import java.util.Stack;

/**
 * Created by Nikhil on 12/26/16.
 */


/** Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Note: You may assume that the string is well-formed:
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/54270/an-java-iterative-solution/2
 */
public class MiniParser {
    //dummy class
    class NestedInteger {
        NestedInteger(int value) {

        }

        NestedInteger() {

        }

        public void add(NestedInteger val) {

        }
    }

    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = i + 1;

            } else if (c == ']') {
                String num = s.substring(l, i);
                if (num.length() != 0) {
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!stack.isEmpty()) {
                    NestedInteger buffer = stack.pop();
                    buffer.add(curr);
                    curr = buffer;
                }
                l = i + 1;

            } else if (c == ',') {
                if (s.charAt(i - 1) != ']') {
                    curr.add(new NestedInteger(Integer.valueOf(s.substring(l, i))));
                }
                l = i + 1;
            }
        }
        return curr;
    }
}
