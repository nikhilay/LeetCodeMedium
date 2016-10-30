/**
 * Created by Nikhil on 10/30/16.
 */

import java.util.HashMap;

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 * Example:
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Therefore the output is 7.
 */

public class CombinationSumFour {
    public static void main(String[] args) {
        int[] input = {1,2,3};
        System.out.println(new CombinationSumFour().combinationSum4(input,4));
    }
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        return recursiveCombinationSum4(nums, target,hmap);
    }

    private int recursiveCombinationSum4(int[] nums, int target,HashMap<Integer, Integer> hmap) {
        if (target == 0) return 1;
        if (target < 0) return 0;
        if(hmap.containsKey(target)) return hmap.get(target);
        int ways =0;
        for(int i =0;i<nums.length;i++){
            ways+= recursiveCombinationSum4(nums,target-nums[i],hmap);
        }
        hmap.put(target, ways);
        return ways;
    }
}
