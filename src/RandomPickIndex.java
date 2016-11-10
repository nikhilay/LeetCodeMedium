import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Nikhil on 11/10/16.
 */

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 */
public class RandomPickIndex {
    private HashMap<Integer, ArrayList<Integer>> helper;

    public RandomPickIndex(int[] nums) {
        helper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (helper.containsKey(value)) {
                helper.get(value).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                helper.put(value, list);
            }
        }
    }

    public int pick(int target) {
        if (helper.containsKey(target)) {
            if (helper.get(target).size() == 1) return helper.get(target).get(0);
            Random rn = new Random();
            return helper.get(target).get(rn.nextInt(helper.get(target).size()));

        } else {
            return -1;
        }
    }
}
