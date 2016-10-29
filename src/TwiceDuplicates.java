/**
 * Created by Nikhil on 10/29/16.
 */

/**
 * Given an array of n elements which contains elements from 0 to n-1,
 * with any of these numbers appearing any number of times.
 * Find these repeating numbers in O(n) and using only constant memory space.
 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 */

public class TwiceDuplicates {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 1, 3, 6, 6};
        new TwiceDuplicates().printRepeating(input);
    }

    public void printRepeating(int arr[]) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[arr[i]-1];
            if(n<0){
                System.out.println(arr[arr[i]-1]*-1T );
            }
            arr[arr[i]-1] = -arr[arr[i]-1];
        }
    }
}
