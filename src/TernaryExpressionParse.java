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
    private Stack<Character> stack;

    public static void main(String[] args) {
        System.out.println(new TernaryExpressionParse().parseTernary("T?5:3"));
    }

    public String parseTernary(String expression) {
        if (expression.length() == 0) return "";
        stack = new Stack();
        return recursivelyParseTernary(expression);
    }

    private String recursivelyParseTernary(String expression) {
        char condition = expression.charAt(0);
        int end = 0;
        for (int i = 2; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '?') {
                stack.push(c);
            } else if (c == ':') {
                if (stack.isEmpty()) {
                    end = i;
                    break;
                }
                stack.pop();

            }

        }
        String left = expression.substring(2, end);
        String right = expression.substring(end + 1);
        if (left.length() > 1) {
            left = recursivelyParseTernary(left);
        }
        if (right.length() > 1) {
            right = recursivelyParseTernary(right);
        }
        if (condition == 'T') {
            return left;
        } else {
            return right;
        }
    }

}
