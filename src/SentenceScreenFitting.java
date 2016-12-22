/**
 * Created by Nikhil on 12/21/16.
 */

/**
 * Given a rows x cols screen and a sentence represented by a list of words,
 * find how many times the given sentence can be fitted on the screen.
 * Note:
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution
 */
public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : sentence) {
            sb.append(s);
            sb.append(" ");
        }
        String s = sb.toString();
        int len = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;

            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;

                }

            }

        }

        return start / len;

    }
}
