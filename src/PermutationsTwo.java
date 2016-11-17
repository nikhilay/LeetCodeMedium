import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhil on 11/16/16.
 */

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, result, new LinkedList<Integer>(), visited);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(nums, result, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
