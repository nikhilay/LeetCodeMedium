/**
 * Created by Nikhil on 12/18/16.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * //-4,-1,-1,0,1,2
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        LinkedList<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                        j++;
                        k--;

                        while (j < k && nums[j] == nums[j - 1]) {
                                j++;

                        }
                        while (j < k && nums[k] == nums[k + 1]) {
                                k--;

                        }
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }

}
