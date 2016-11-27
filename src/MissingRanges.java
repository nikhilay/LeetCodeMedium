/**
 * Created by Nikhil on 11/27/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array where the range
 * of elements are in the inclusive range [lower, upper], return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        if (nums == null) return result;
        long start = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != start) {
                if (nums[i] - start == 1) {
                    result.add(start + "");
                } else if (nums[i] - start > 1) {
                    result.add(start + "->" + (nums[i] - 1));
                }
            }
            start = (long)nums[i] + 1;
        }
        if (start == upper) {
            result.add(start + "");
        } else if (upper > start) {
            result.add(start + "->" + upper);
        }


        return result;
    }
}
