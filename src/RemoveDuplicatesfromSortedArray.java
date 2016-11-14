/**
 * Created by Nikhil on 11/13/16.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count =1;
        int sum =1;
        int index =1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1] && sum<2){
                nums[index] = nums[i+1];
                index++;
                count+=sum;
                sum=2;
            }else if(nums[i]!=nums[i+1]){
                nums[index] = nums[i+1];
                index++;
                sum=1;
                count+=sum;
            }

        }
        return count;
    }
}
