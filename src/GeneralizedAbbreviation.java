/**
 * Created by Nikhil on 10/27/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        if (word == null) return res;
        backtracking(word, res, 0, "", 0);
        return res;
    }

    private void backtracking(String word, List<String> res, int pos, String curr, int count) {
        if (pos == word.length()) {
            if (count > 0) curr += count;
            res.add(curr);
        } else {
            backtracking(word, res, pos + 1, curr, count + 1);
            backtracking(word, res, pos + 1, curr + (count > 0 ? count : "") + word.charAt(pos), 0);
        }

    }


}

