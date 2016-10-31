/**
 * Created by Nikhil on 10/30/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing
 * all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '/' || c == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                for (int j : part1Res) {
                    for (int k : part2Res) {
                        int val = 0;
                        switch (c) {
                            case '+':
                                val = j + k;
                                break;
                            case '-':
                                val = j - k;
                                break;
                            case '/':
                                val = j / k;
                                break;
                            case '*':
                                val = j * k;
                                break;
                        }
                        result.add(val);
                    }
                }
            }
        }
        if(result.isEmpty()){
       result.add(Integer.valueOf(input));
        }
       return result;
    }

}
