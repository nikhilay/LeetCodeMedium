/**
 * Created by Nikhil on 12/26/16.
 */

/**
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely
 * large positive integer given in the form of an array.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/50489/c-clean-and-short-solution/2
 */
public class SuperPow {
    int base = 1337;

    public int superPow(int a, int[] b) {
        if (b == null) return 1;
        int index = b.length - 1;
        return superPow(a, b, index);
    }
    private int superPow(int a, int[] b, int index){
        if(index<0) return 1;
        return  powMod(superPow(a,b,index-1),10)*powMod(a,b[index])%base;
    }

    private int powMod(int a, int b) {
        a = a % base;
        int result = 1 % base;
        for (int i = 0; i < b; i++) {
            result = (result * a) % base;
        }
        return result;
    }
}
