/**
 * Created by Nikhil on 12/2/16.
 */

import java.util.LinkedList;
import java.util.List;
/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        long lowerRange = nums[0];
        long higherRange = nums[0]-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                higherRange = nums[i];
            }else{
                addToResult(lowerRange,higherRange,res);
                lowerRange = nums[i];
                higherRange = nums[i]-1;

            }
        }
        addToResult(lowerRange,higherRange,res);
        return res;
    }

    private void addToResult(long lowerRange, long higherRange, List<String> res){
        StringBuilder sb = new StringBuilder();
        if(lowerRange<higherRange){
            sb.append(lowerRange +"->"+higherRange);
        }else{
            sb.append(lowerRange);
        }
        res.add(sb.toString());
    }
}
