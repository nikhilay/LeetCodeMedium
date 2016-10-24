/**
 * Created by Nikhil on 10/24/16.
 */

import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
 * and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 */
public class CountingBits {
    //The first Solution. Time complexity O(n*32)
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;

        for (int i = 1; i <= num; i++) {
            result[i] = getBits(i);

        }

        return result;
    }

    private int getBits(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    //Efficient Solution

    public int[] countBitsEfficientSolution(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        int pow = 1;
        int p = 1;
        for (int i = 1; i <= num; i++) {
            if (i == pow) {
                result[i] = 1;
                pow <<= 1;
                p = 1;
            } else {
                result[i] = result[p] + 1;
                p++;

            }

        }

        return result;
    }
}
