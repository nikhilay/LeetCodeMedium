/**
 * Created by Nikhil on 11/12/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> list = new LinkedList<>();
            int index = nums.length - 1;
            int k = i;
            while (k != 0) {
                if ((k & 1) == 1) {
                    list.add(nums[index]);
                }
                index--;
                k >>= 1;
            }
            result.add(list);
        }
        return result;
    }
}
