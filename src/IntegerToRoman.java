/**
 * Created by Nikhil on 10/26/16.
 */

import java.util.HashMap;

import static com.sun.javafx.css.SizeUnits.CM;
import static javafx.scene.input.KeyCode.M;
import static javax.swing.UIManager.put;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 *         HashMap<Integer, Character> hmap = new HashMap<>();
 hmap.put(1, 'I');
 hmap.put(5, 'V');
 hmap.put(10, 'X');
 hmap.put(50, 'L');
 hmap.put(100, 'C');
 hmap.put(500, 'D');
 hmap.put(1000, 'M');
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
