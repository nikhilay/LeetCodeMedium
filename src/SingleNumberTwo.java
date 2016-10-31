/**
 * Created by Nikhil on 10/30/16.
 */

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumberTwo {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum = sum % 3;
            ans |= sum << i;
        }

        return ans;
    }
}
