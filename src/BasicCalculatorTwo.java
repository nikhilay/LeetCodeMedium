import java.util.Stack;

/**
 * Created by Nikhil on 11/22/16.
 */

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 */
public class BasicCalculatorTwo {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        char sign = '+';
        int num = 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && ' ' != c) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;

            }

        }
        int result = 0;

        for (int i : stack) {
            result += i;
        }
        return result;
    }
}
