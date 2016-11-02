/**
 * Created by Nikhil on 11/1/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode – Factor Combinations (Java)
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * Note:
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 */

//Similar Solution
//  https://discuss.leetcode.com/topic/21082/my-recursive-dfs-java-solution
public class FactorCombination {
    public static void main(String[] args) {
        new FactorCombination().getFactors(10);
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        backtracker(result, new LinkedList<Integer>(), n, 2);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + ", ");
            }
            System.out.print("\n");
        }
        return result;
    }

    private void backtracker(List<List<Integer>> result, List<Integer> memo, int n, int start) {
        if (n == 0) return;
        if (!memo.isEmpty()) {
            result.add(new LinkedList<>(memo));
        }
        for (int i = start; i <= n; i++) {
            if ((n % i) == 0) {
                List<Integer> tempList = new LinkedList<Integer>();
                tempList.addAll(memo);
                tempList.add(i);
                backtracker(result, tempList, n / i, i);
                tempList.remove(tempList.remove(tempList.size() - 1));
            }
        }
    }
}
