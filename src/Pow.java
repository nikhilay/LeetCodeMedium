/**
 * Created by Nikhil on 11/30/16.
 */

/**
 * Implement pow(x, n)
 */
public class Pow {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        if(n==Integer.MIN_VALUE){
            n++;
            n =-n;
            x= 1/x;
            return x*x*myPow(x*x,n/2);

        }
        if(n<0){
            n =-n;
            x= 1/x;

        }

        return (n%2)==0?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}
