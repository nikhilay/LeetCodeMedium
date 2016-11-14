/**
 * Created by Nikhil on 11/14/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/8465/my-java-solution-with-fifo-queue
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<>();
        if(digits.length()==0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String t = result.poll();
                for (int j = 0; j < mapping[index].length(); j++) {
                    result.add(t + mapping[index].charAt(j));
                }
            }
        }
        return result;
    }
}
