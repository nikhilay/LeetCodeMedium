/**
 * Created by Nikhil on 10/31/16.
 */

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 */
//Solution
//https://discuss.leetcode.com/topic/37310/fantastic-clean-java-dp-solution-with-detail-explaination/2

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int level = 2; level <= n; level++) {
            for (int j = 1; j <= level; j++) {
                memo[level] += memo[j-1] * memo[level - j];
            }
        }
        return memo[n];
    }
}
