/**
 * Created by Nikhil on 11/11/16.
 */

import java.util.*;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInanArray {
    public static void main(String[] args) {
        int[] input ={-1,2,0};
        System.out.println(new KthLargestElementInanArray().findKthLargest(input,2));
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums==null ||nums.length==0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums){
            pq.add(i);
            if(pq.size()==(k+1)){
                pq.poll();
            }
        }
     return pq.peek();
    }

    public int findKthLargestEff(int[] nums, int k) {
        if(nums==null ||nums.length==0) return -1;
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
