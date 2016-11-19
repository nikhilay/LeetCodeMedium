/**
 * Created by Nikhil on 11/18/16.
 */

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/57372/java-3ms-divide-and-conquer-recursion-solution/2
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        new LongestSubstringwithAtLeastKRepeatingCharacters().longestSubstring("ababacb", 3);
    }

    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (start > end) return 0;
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            if (count[i] < k) {
                for (int j = start; j < end; j++) {
                    if (s.charAt(j) == i + 'a') {
                        int left = helper(s, start, j, k);
                        int right = helper(s, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
