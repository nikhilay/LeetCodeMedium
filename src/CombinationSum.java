import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhil on 11/13/16.
 */

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates == null) return result;
        Arrays.sort(candidates);
        helper(candidates, target, new LinkedList<Integer>(), result, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> list, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], list, result, i);
            list.remove(list.size() - 1);
        }
    }
}
