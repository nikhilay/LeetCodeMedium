/**
 * Created by Nikhil on 11/10/16.
 */

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * Given [5, 4, 3, 2, 1],
 * return false.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/37577/my-accepted-java-solution-for-this-question-only-7-lines-clear-and-concise
 */
public class IncreasingTripletSubSequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= firstMin) {
                firstMin = i;
            } else if (i <= secondMin) {
                secondMin = i;
            } else {
                return true;
            }
        }
        return false;
    }

}
