/**
 * Created by Nikhil on 10/25/16.
 */

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Stack;

import static javafx.scene.input.KeyCode.T;

/**
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression.
 * You can always assume that the given expression is
 * valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).
 * Note:
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 * Input: "F?1:T?4:5"
 * Example 2
 * Output: "4"
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 * "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 * -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 * -> "4"                                    -> "4"
 * Input: "T?T?F:5:3"
 * Example 3
 * Output: "F"
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 * "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 * -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 * -> "F"                                    -> "F"
 */


public class TernaryExpressionParse {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char left = stack.pop();
                stack.pop();
                char right = stack.pop();
                stack.push(c == 'T' ? left : right);
            } else if (c != '(' && c != ')') {
                stack.push(c);
            }
        }
        return stack.peek().toString();
    }

}
