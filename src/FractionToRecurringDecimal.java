/**
 * Created by Nikhil on 12/4/16.
 */
import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }
        int sign = (numerator>0) ^ (denominator>0)?-1:1;
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();
        sb.append(sign>0?"":"-");
        sb.append(num/den);
        num %=den;
        if(num==0){
            return sb.toString();
        }
        HashMap<Long, Integer>  hmap = new HashMap<>();
        sb.append(".");
        hmap.put(num,sb.length());
        while(num!=0){
            num *=10;
            sb.append(num/den);
            num %=den;
            if(hmap.containsKey(num)){
                int index = hmap.get(num);
                sb.insert(index,"(");
                sb.append(")");
                break;

            }else{
                hmap.put(num,sb.length());
            }
        }
        return sb.toString();
    }
}
