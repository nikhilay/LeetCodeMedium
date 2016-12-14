/**
 * Created by Nikhil on 12/14/16.
 */

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/21848/ac-relatively-short-and-very-clear-java-solution
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int currentLen = 0;
        String res = "";


        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currentLen - 1, i)) {
                res = s.substring(i - currentLen - 1, i + 1);
                currentLen = currentLen + 2;
            } else if (isPalindrome(s, i - currentLen, i)) {
                res = s.substring(i - currentLen, i + 1);
                currentLen = currentLen + 1;

            }
        }
        return res;
    }


    private boolean isPalindrome(String word, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (word.charAt(begin) != word.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
