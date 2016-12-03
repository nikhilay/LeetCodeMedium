/**
 * Created by Nikhil on 12/2/16.
 */

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

/**
 * Inspired from wikipedia article
 * https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] input ={1,3,2};
        new NextPermutation().nextPermutation(input);
    }
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0) return;
        int k = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                k = i;
                break;
            }
        }
        if(k==-1){
            Arrays.sort(nums);
            return;
        }
        int l = -1;
        for(int i=nums.length-1;i>k;i--){
            if(nums[i]>nums[k]){
                l=i;
                break;
            }
        }
        int temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;
        reverseSort(k+1,nums);
    }
    private void reverseSort(int startIndex,int[] nums){
        int len = nums.length-1;
        for(int i = startIndex;i<len;i++,len--){
            int temp = nums[len];
            nums[len] = nums[i];
            nums[i] = temp;
        }
    }

}
