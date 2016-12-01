/**
 * Created by Nikhil on 11/30/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array of size n,
 * find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/17564/boyer-moore-majority-vote-algorithm-and-my-elaboration
 */
public class MajorityElementTwo {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;

        int count1 = 0;
        int count2 = 0;
        int num1 = nums[0];
        int num2 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }

        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (num1 == i) {
                count1++;
            } else if (num2 == i) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(num1);
        }
        if (count2 > nums.length / 3) {
            result.add(num2);
        }
        return result;
    }
}
