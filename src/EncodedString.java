import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikhil on 12/2/16.
 */

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * }
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * Implement the encode and decode methods.
 */
public class EncodedString {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length());
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String>  result = new LinkedList<>();
        int i=0;
        while(i<s.length()){
            int slashIndex = s.indexOf("/",i);
            int size = Integer.valueOf(s.substring(i,slashIndex));
            result.add(s.substring(slashIndex+1,slashIndex+size+1));
            i = size+slashIndex+1;
        }

        return result;
    }
}
