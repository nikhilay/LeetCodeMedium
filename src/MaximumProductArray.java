/**
 * Created by Nikhil on 12/14/16.
 */

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/27155/my-concise-dp-o-n-java-solution-with-o-1-extra-space
 */

public class MaximumProductArray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>0){
                max = Math.max(nums[i]*max,nums[i]);
                min = Math.min(nums[i]*min,nums[i]);

            }else{
                int temp = max;
                max = Math.max(nums[i]*min,nums[i]);
                min = Math.min(nums[i]*temp,nums[i]);

            }
            result = Math.max(result,max);

        }

        return result;
    }
}
