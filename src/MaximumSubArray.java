/**
 * Created by Nikhil on 11/2/16.
 */

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

/**
 * Inspired from
 * http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
 */

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int[] memo = new int[nums.length];
        memo[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i], nums[i] + memo[i - 1]);
            max = Math.max(memo[i], max);
        }
        return max;
    }
}
