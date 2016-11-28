import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 11/27/16 for Bookings.com test
 */
public class DeltaEncoding {
    public void deltaEncoding(int[] arr){
        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for(int i = 1;i<arr.length;i++){
            int diff = arr[i]-arr[i-1];
            if(diff>127 || diff<-127){
                result.add(-128);
            }
            result.add(diff);
        }
        for(int i:result){
            System.out.print(i+" ");
        }
    }

}
