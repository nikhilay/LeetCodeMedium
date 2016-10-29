/**
 * Created by Nikhil on 10/29/16.
 */

import java.util.HashMap;

import static javafx.scene.input.KeyCode.M;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 */

public class MaximumSizeSubArray {
    public static void main(String[] args) {
        int[] input = {1, -1, 5, -2, 2,1,1,1};
        new MaximumSizeSubArray().maxSubArrayLen(input,3);
    }

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = i + 1;
            if (hmap.containsKey(sum - k)) {

                max = Math.max(max, i - hmap.get(sum - k));
            }
            if (!hmap.containsKey(sum)) {
                hmap.put(sum, i);
            }
        }
        System.out.println("Maximum length of a subarray is " + max);
        return max;
    }
}
