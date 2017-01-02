/**
 * Created by Nikhil on 1/2/17.
 */

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        int[] map = new int[256];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            map[index]++;
            max = Math.max(max, map[index]);
        }
        String[] bucket = new String[max + 1];
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                String str = bucket[map[i]];
                bucket[map[i]] = str == null ? "" + (char) i : str + (char) i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (int j = 0; j < bucket[i].length(); j++) {
                char c = bucket[i].charAt(j);
                for (int k = 0; k < i; k++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
