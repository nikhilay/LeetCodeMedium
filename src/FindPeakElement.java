/**
 * Created by Nikhil on 11/12/16.
 */

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int len = nums.length;
        for(int i =0;i<len;i++){

            long left = i-1>=0?nums[i-1]:Long.MIN_VALUE;
            long center = nums[i];
            long right = i+1<len?nums[i+1]:Long.MIN_VALUE;

            if(center>left && center>right){
                return i;
            }

        }

        return -1;
    }

    public int findPeakElementEff(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int low = 0;
        int high = nums.length -1 ;
        while(low<high){
            int mid = low +(high-low)/2;

            if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
