/**
 * Created by Nikhil on 11/14/16.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if( nums==null || nums.length==0) return result;
        Arrays.sort(nums);
        helper(nums, result, 0, new LinkedList<Integer>());
        return result;
    }

    private void helper(int[] nums,List<List<Integer>> result, int pos,List<Integer> list){
        if(pos>nums.length) return;
        result.add(new LinkedList<>(list));
        int i= pos;
        while(i<nums.length){
            list.add(nums[i]);
            helper(nums, result, i+1, new LinkedList<>(list));
            list.remove(list.size()-1);
            i++;
            while(i<nums.length && nums[i]==nums[i-1]){
                i++;
            }
        }

    }
}
