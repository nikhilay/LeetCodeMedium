/**
 * Created by Nikhil on 10/30/16.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

public class GeneratedParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        backTrack(result, "", 0, 0, n);
        return result;
    }

    private void backTrack(List<String> result, String str, int open, int close, int max) {

        if ((str.length() == max * 2)) {
            result.add(str);
            return;
        }
        if(open<max){
            backTrack(result,str+"(",open+1,close,max);
        }

        if(close<open){
            backTrack(result,str+")",open,close+1,max);
        }
    }
}
