/**
 * Created by Nikhil on 10/24/16.
 */

import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 * For example, these are arithmetic sequence:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * 1, 1, 2, 5, 7
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such
 * that 0 <= P < Q < N.
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * The function should return the number of arithmetic slices in the array A.
 */
public class ArtithmeticSlices {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 8, 9, 10};
        new ArtithmeticSlices().numberOfArithmeticSlicesEfficient(input);
    }

    //efficientSolution
    public int numberOfArithmeticSlicesEfficient(int[] a) {
        if (a == null || a.length < 3) return 0;
        int result = 0;
        int numbers = 1;
        for (int i = 2; i < a.length; i++) {
            if (a[i] - a[i - 1] == a[i - 1] - a[i - 2]) {
                numbers++;
            } else {
                result += getNoOfWaysEfficient(numbers + 1);
                numbers = 1;
            }


        }
        result += getNoOfWaysEfficient(numbers + 1);
        return result;

    }

    private int getNoOfWaysEfficient(int numbers) {
        ;
        int threshold = 3;
        if (numbers >= threshold) {
            return (numbers - 1) * (numbers - 2) / 2;
        }
        return 0;
    }

    public int numberOfArithmeticSlices(int[] a) {
        if (a.length < 3) return 0;
        int[] differenceArray = new int[a.length - 1];

        for (int i = 1; i < a.length; i++) {
            differenceArray[i - 1] = a[i] - a[i - 1];
        }

        int result = 0;
        int numbers = 1;
        for (int i = 1; i < differenceArray.length; i++) {
            if (differenceArray[i - 1] == differenceArray[i]) {
                numbers++;
                if (i + 1 == differenceArray.length) {
                    result += getNoOfWays(numbers + 1);
                }
            } else {
                result += getNoOfWays(numbers + 1);
                numbers = 1;
            }


        }
        System.out.println(result);
        return result;
    }

    private int getNoOfWays(int numbers) {
        int result = 0;
        int threshold = 3;
        if (numbers >= threshold) {
            int j = threshold;
            while (j <= numbers) {
                for (int index = 0; (index + j - 1) < numbers; index++) {
                    result++;
                }
                j++;
            }
        }
        return result;
    }
}
