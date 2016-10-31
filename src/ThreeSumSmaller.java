/**
 * Created by Nikhil on 10/31/16.
 */

import java.util.Arrays;
/**
 * Given an array of n integers nums and a target, find the number
 * of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Follow up:
 * Could you solve it in O(n^2) runtime?Ò
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) return 0;
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            for (int j = low; j < nums.length; j++) {
                if (nums[i] + nums[low] + nums[high] < target) {
                    result += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}
