/**
 * Created by Nikhil on 11/25/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 */
public class PalindromePermutationTwo {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        int odd = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hmap.put(c, hmap.containsKey(c) ? hmap.get(c) + 1 : 1);
            odd += hmap.get(c) % 2 != 0 ? 1 : -1;
        }
        System.out.println(odd);
        if (odd > 1) return result;
        String mid = "";
        List<Character> charList = new ArrayList<>();

        for (Character c : hmap.keySet()) {
            int value = hmap.get(c);
            if (value % 2 != 0) mid += c;
            for (int i = 0; i < value / 2; i++) charList.add(c);
        }

        helper(result, charList, mid, new StringBuilder(), new boolean[charList.size()]);
        return result;
    }

    private void helper(List<String> result, List<Character> list, String mid, StringBuilder sb, boolean[] visited) {
        if (sb.length() == list.size()) {
            result.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i - 1) == list.get(i) && !visited[i - 1]) continue;
            if (!visited[i]) {
                sb.append(list.get(i));
                visited[i] = true;
                helper(result, list, mid, sb, visited);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}
