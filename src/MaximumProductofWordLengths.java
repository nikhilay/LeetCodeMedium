/**
 * Created by Nikhil on 10/27/16.
 */

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. You may assume that each word will
 * contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * <p>
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * <p>
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 */
public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {

        if (words == null || words.length == 0) return 0;

        int[] values = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String st = words[i];
            for (int j = 0; j < st.length(); j++) {
                values[i] |= 1 << (st.charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((values[i] & values[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
