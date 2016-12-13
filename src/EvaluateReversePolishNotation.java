/**
 * Created by Nikhil on 12/13/16.
 */

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(s.equals("-")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1-num2);

            }else if(s.equals("/")){
                int num2= stack.pop();
                int num1 = stack.pop();
                stack.push(num1/num2);

            }else if(s.equals("*")){
                stack.push(stack.pop()*stack.pop());

            }else{
                stack.push(Integer.valueOf(s));
            }

        }
        return stack.pop();

    }
}
