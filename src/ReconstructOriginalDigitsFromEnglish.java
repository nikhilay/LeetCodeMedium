/**
 * Created by Nikhil on 10/30/16.
 */

/**
 * Given a non-empty string containing an out-of-order
 * English representation of digits 0-9, output the digits in ascending order.
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * Output: "45"
 */

public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        System.out.println( new ReconstructOriginalDigitsFromEnglish().originalDigits("fviefuro"));
    }

    /**
     * The even digits all have a unique letter while the odd digits all don't:
     * zero: Only digit with z
     * two: Only digit with w
     * four: Only digit with u
     * six: Only digit with x
     * eight: Only digit with g
     * The odd ones for easy looking, each one's letters all also appear in other digit words:
     * one, three, five, seven, nine
     * one- two 'o'(one and zero)
     * three - two 't'(two and three)
     * five - two f (four and five)
     * seven- two 's' (six and seven)
     * nine - two 'n' (seven and nine)
     */

    public String originalDigits(String s) {
        int[] helper = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'z':
                    helper[0]++;
                    break;
                case 'w':
                    helper[2]++;
                    break;
                case 'u':
                    helper[4]++;
                    break;
                case 'x':
                    helper[6]++;
                    break;
                case 'g':
                    helper[8]++;
                    break;
                case 'o':
                    helper[1]++;
                    break;
                case 'h':
                    helper[3]++;
                    break;
                case 'f':
                    helper[5]++;
                    break;
                case 's':
                    helper[7]++;
                    break;
                case 'i':
                    helper[9]++;
                    break;

            }
        }

        helper[3]-=helper[8];
        helper[5]-=helper[4];
        helper[7]-=helper[6];
        helper[1]=helper[1]-helper[2]-helper[0]-helper[4];
        helper[9]=helper[9]-helper[6]-helper[8]- helper[5];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<helper.length;i++){
            for(int j =0;j<helper[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
