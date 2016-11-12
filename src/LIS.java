import java.util.Arrays;

/**
 * Created by Nikhil on 11/11/16.
 */

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 */

public class LIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    result[i] = Math.max(result[j] + 1, result[i]);
                }
            }
        }
        int max = 1;
        for (int i : result) {
            max = Math.max(i, max);
        }
        return max;
    }

}
