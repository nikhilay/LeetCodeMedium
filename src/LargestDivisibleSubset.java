/**
 * Created by Nikhil on 11/17/16.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj)
 * of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * If there are multiple solutions, return any subset is fine.
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/49424/java-solution-in-32ms-o-n-2-time-o-n-space
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if(nums==null || nums.length==0) return result;
        Arrays.sort(nums);
        int[] maxSubsetSize = new int[nums.length];
        int[] indexTracking = new int[nums.length];
        int max =0;
        int index =0;

        for(int i=0;i<nums.length;i++){
            maxSubsetSize[i]=1;
            indexTracking[i] =-1;
            for(int j = i-1;j>=0;j--){
                if(nums[i]%nums[j]==0 && maxSubsetSize[j]+1>maxSubsetSize[i]){
                    maxSubsetSize[i] = maxSubsetSize[j]+1;
                    indexTracking[i] = j;
                }

                if(maxSubsetSize[i]>max){
                    max = maxSubsetSize[i] ;
                    index = i;
                }

            }
        }
        
        while(index!=-1){

            result.add(nums[index]);
            index = indexTracking[index];
        }
        return result;

    }
}
