import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhil on 11/16/16.
 */

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */

public class CombinationsSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        helper(candidates, target, result, new LinkedList<Integer>(), 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int start) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                List<Integer> temp = new LinkedList<>();
                temp.addAll(list);
                temp.add(candidates[i]);
                helper(candidates, target - candidates[i], result, temp, i + 1);
                while ((i + 1) < candidates.length && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }
}
