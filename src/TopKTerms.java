/**
 * Created by Nikhil on 10/26/16.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

public class TopKTerms {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i : nums) {
            if (hmap.containsKey(i)) {
                int count = hmap.get(i);
                hmap.put(i, count + 1);

            } else {
                hmap.put(i, 1);
            }
        }
        int max = 0;
        for (int i : hmap.keySet()) {
            max = Math.max(max, hmap.get(i));
        }

        ArrayList<Integer>[] arr = new ArrayList[max + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i : hmap.keySet()) {
            int freq = hmap.get(i);
            arr[freq].add(i);
        }
        List<Integer> result = new LinkedList<>();
        int remaining = k;
        for (int j = max; j >= 0; j--) {
            int size = arr[j].size();

            if (size > 0) {
                int endIndex = remaining > size ? size : remaining;
                result.addAll(arr[j].subList(0, endIndex));
                if (result.size() == k) {
                    return result;
                }
                remaining = remaining - size;
            }

        }
        return result;
    }
}
