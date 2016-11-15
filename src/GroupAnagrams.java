import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Created by Nikhil on 11/14/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if (strs == null || strs.length == 0) return result;
        HashMap<String, List<String>> hmap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!hmap.containsKey(sorted)) {
                hmap.put(sorted, new LinkedList<String>());
            }
            hmap.get(sorted).add(str);
        }
        result.addAll(hmap.values());
        return result;
    }
}
