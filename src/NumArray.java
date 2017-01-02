/**
 * Created by Nikhil on 12/6/16.
 */
public class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    void update(int i, int val) {
        if(i>=0 && i<nums.length){
            nums[i] = val;
        }
    }

    public int sumRange(int i, int j) {
        int sum =0;
      for(int index =i;index<=j;index++){
          sum+=nums[index];
      }
      return sum;
    }
}
