/**
 * Created by Nikhil on 10/28/16.
 */

/**
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * Result: [-23, -5, 1, 7]
 */

public class SortedArrayTransformed {
    public static void main(String[] args) {
        int[] input = {-4, -2, 2, 4};

        new SortedArrayTransformed().SortTransformedArray(input, 1, 3, 5);
    }

    public void SortTransformedArray(int[] nums, int a, int b, int c) {
        long[] result = new long[nums.length];
        int n = nums.length;
        int index = a >= 0 ? n - 1 : 0;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (a >= 0) {
                result[index--] = cal(nums[i], a, b, c) > cal(nums[j], a, b, c) ? cal(nums[i++], a, b, c) : cal(nums[j--], a, b, c);
            } else {
                result[index++] = cal(nums[i], a, b, c) > cal(nums[j], a, b, c) ? cal(nums[i++], a, b, c) : cal(nums[j--], a, b, c);
            }

        }
        print(result);

    }

    private int cal(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    private void print(long[] input) {
        for (long r : input) {
            System.out.print(r + ", ");
        }
    }
}
