/**
 * Created by Nikhil on 10/25/16.
 */

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 * Note:
 * You may assume word1 and word2 are both in the list.Understand the problem:
 */
public class ShortestWordDistanceThree {
    public static void main(String[] args) {
        String[] input = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        System.out.println(new ShortestWordDistanceThree().shortestWordDistance(input, word1, word2));
    }

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return -1;
        }
        long min = Integer.MAX_VALUE;
        long ind1 = min;
        long ind2 = -min;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                ind1 = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    ind1 = ind2;
                }
                ind2 = i;

            }
            min = Math.min(min, Math.abs(ind1 - ind2));
        }
        return (int)min;
    }
}
