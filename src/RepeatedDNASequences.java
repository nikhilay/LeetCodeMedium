/**
 * Created by Nikhil on 11/27/16.
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        HashMap<String, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String subSeq = s.substring(i, i + 10);
            hmap.put(subSeq, hmap.containsKey(subSeq) ? hmap.get(subSeq) + 1 : 1);
        }
        for(String st:hmap.keySet()){
            if(hmap.get(st)>1){
                result.add(st);
            }
        }
        return result;
    }
}
