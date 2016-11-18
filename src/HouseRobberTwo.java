/**
 * Created by Nikhil on 11/17/16.
 */
public class HouseRobberTwo {
    //House Robber Solution -
    public int robHouseRobberOner(int[] input) {
        if (input == null || input.length == 0) return 0;
        int[] memo = new int[input.length + 1];
        memo[0] = 0;
        memo[1] = input[0];
        for (int i = 2; i < memo.length; i++) {
            int maxAmount = Math.max(memo[i - 2] + input[i - 1], memo[i - 1]);
            memo[i] = maxAmount;

        }
        return memo[input.length];
    }


    //Inspired from https://discuss.leetcode.com/topic/23097/java-clean-short-solution-dp

    /**
     * Note: This is an extension of House Robber.
     * After robbing those houses on that street, the thief has
     * found himself a new place for his thievery so that he will not get too much attention.
     * This time, all houses at this place are arranged in a circle. That means the first house
     * is the neighbor of the last one. Meanwhile, the security system for these houses remain
     * the same as for those in the previous street.
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     */
    public int rob(int[] input) {
        if (input == null || input.length == 0) return 0;
        if (input.length == 1) return input[0];
        return Math.max(robHouseRobberTwo(input, 0, input.length - 2), robHouseRobberTwo(input, 1, input.length - 1));
    }

    public int robHouseRobberTwo(int[] input, int start, int end) {
        int rob = 0;
        int preRob = 0;
        int notRob = 0;
        int preNotRob = 0;

        for (int i = start; i <= end; i++) {
            rob = preNotRob + input[i];
            notRob = Math.max(preRob, preNotRob);
            preRob = rob;
            preNotRob = notRob;
        }
        return Math.max(rob, notRob);
    }
}
