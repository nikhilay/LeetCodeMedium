/**
 * Created by Nikhil on 10/30/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
public class CombinationSumThree {
    public static void main(String[] args) {
        new CombinationSumThree().combinationSum3(3,7);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(result,1, k, n,list);
        return result;
    }

    private void helper(List<List<Integer>> result,int start, int k, int n,List<Integer> list) {
        if(k==0 && n==0){
            result.add(list);
            return;
        }
        if(k==0||n<0){
            return;
        }

        for(int i=start;i<=9;i++){
            List<Integer> temp = new LinkedList<>();
            temp.addAll(list);
            temp.add(i);
            helper(result,i+1,k-1,n-i,temp);
        }

    }
}
