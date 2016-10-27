/**
 * Created by Nikhil on 10/26/16.
 */

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int actualSum =(nums.length+1)*(nums.length)/2;
        return actualSum - sum;
    }

    public int bitWayofFindingmissingNumber(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        int xor =0;
        int i;
        for(i=0;i<nums.length;i++){
           xor = xor ^i^nums[i];
        }
        return xor^i;
    }
}
