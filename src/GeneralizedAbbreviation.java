/**
 * Created by Nikhil on 10/27/16.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */

public class GeneralizedAbbreviation {

    public static void main(String[] args) {
        new GeneralizedAbbreviation().generateAbbreviations("word");
    }

    public void generateAbbreviations(String word) {
        List<String> result = new LinkedList<>();
        if (word == null || word.length() == 0) return;
        int n = (int) Math.pow(2, word.length());
        result.add(word);
        StringBuilder sb;
        for (int i = 15; i < n; i++) {
            char[] arr = word.toCharArray();
            int k = i;
            int count = word.length() - 1;
            while (k != 0) {
                if ((k & 1) == 1) {
                    arr[count] = '1';
                }
                count--;
                k >>= 1;
            }
            sb = new StringBuilder();
            int cnt = 1;
            int j;
            for (j = 1; j < arr.length; j++) {
                if (arr[j] == '1' && arr[j - 1] == '1') {
                    cnt++;
                    j =j+1;
                } else {
                    if (cnt >= 2) {
                        sb.append(cnt);
                    }
                    sb.append(arr[j - 1]);
                    cnt = 1;
                }
            }
            if (cnt >= 2 && j >= arr.length) {
                sb.append(cnt);
            } else {
                sb.append(arr[j - 1]);
            }
            result.add(sb.toString());
        }
        for (String s : result) {
            System.out.print(s + ", ");
        }

    }
}

