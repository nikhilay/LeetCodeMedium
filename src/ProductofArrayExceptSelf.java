/**
 * Created by Nikhil on 10/25/16.
 */

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i]
 * is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 */

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            result[j] *= right;
            right *= nums[j];
        }
        return result;
    }
}
