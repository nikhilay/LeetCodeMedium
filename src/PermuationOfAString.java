import java.util.LinkedList;
import java.util.List;



/**
 * Created by Nikhil on 11/22/16.
 */
public class PermuationOfAString {
    public static void main(String[] args) {
        new PermuationOfAString().givePermuations("abc");
    }
    public List<String>  givePermuations(String input){
        List<String> result = new LinkedList<>();
        if(input==null || input.length()==0) return result;
        char[] inputArr = input.toCharArray();
        helper("", input, result);
        int index =1;
        for(String s:result){
            System.out.println(s + " "+index);
            index++;
        }
        return result;
    }

    private void  helper(String prefix, String input,List<String> result){
        if(input.length()==0){
            result.add(prefix);
            return;
        }else{
            for(int i =0;i<input.length();i++) {
                helper(prefix + input.charAt(i),input.substring(0,i)+input.substring(i+1),result);
            }

        }
    }

}
