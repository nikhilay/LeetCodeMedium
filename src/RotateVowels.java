import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Nikhil on 1/3/17.
 */
public class RotateVowels {
    public static void main(String[] args) {
        new RotateVowels().rotateVowels("orange",1);
    }


    public void rotateVowels(String s, int k) {
        HashSet<Character> hset = new HashSet<>();
        hset.add('a');
        hset.add('e');
        hset.add('i');
        hset.add('o');
        hset.add('u');
        hset.add('A');
        hset.add('E');
        hset.add('I');
        hset.add('O');
        hset.add('U');

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (hset.contains(s.charAt(i))) list.add(i);
        }
        char[] arr = s.toCharArray();
        for (int i = list.size()-1; i>0 ; i--) {
            swap(arr,i,k);

        }
        System.out.println(new String(arr));

    }

    private void swap(char[] arr, int index,int k) {
        char temp  = arr[index];
        arr[index] = arr[(index+k)%arr.length];
        arr[(index+k)%arr.length] = temp;
    }
}
