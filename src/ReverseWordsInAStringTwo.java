/**
 * Created by Nikhil on 11/28/16.
 */

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Could you do it in-place without allocating extra space?L
 */
public class ReverseWordsInAStringTwo {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        reverse(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }


        }
        reverse(s, start, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        if (start < end) {
            for (int i = start, j = end; i < j; i++, j--) {
                char c = s[i];
                s[i] = s[j];
                s[j] = c;
            }
        }
    }
}
