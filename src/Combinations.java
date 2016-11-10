/**
 * Created by Nikhil on 11/10/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if(k>n) return result;
        List<Integer>  list = new LinkedList<>();
        helper(result,n,k,list, 1);
        return result;
    }
    private void helper(List<List<Integer>> result, int n, int k,List<Integer> list, int start){
        if(list.size()==k){
            result.add( new LinkedList<>(list));
            return;
        }
        List<Integer>  temp = new LinkedList<>();
        temp.addAll(list);
        for(int i =start;i<=n;i++){
            temp.add(i);
            helper(result, n, k, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
