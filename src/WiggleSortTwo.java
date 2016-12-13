/**
 * Created by Nikhil on 12/13/16.
 */

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/33084/ac-java-solution-7ms
 */
public class WiggleSortTwo {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] buffer = new int[nums.length];
        int mid = nums.length%2==0?(nums.length/2) -1:nums.length/2;
        int index =0;
        for(int i=0;i<=mid;i++){
            buffer[index] = nums[mid-i];
            if(index+1 <nums.length){
                buffer[index+1] = nums[nums.length-1-i];
            }
            index +=2;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]= buffer[i];
        }
    }
}
