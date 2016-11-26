import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 11/26/16.
 */
public class TaskScheduling {
    /*
 * Complete the function below.
 */

    static int[] taskOrdering(int[][] dependency) {


        if(dependency == null || dependency.length == 0)
            return new int[0];


        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> degree = new HashMap<>();
        Queue<Integer> zero = new LinkedList<>();

        for(int i = 0 ; i < dependency.length ; i++){
            if(degree.containsKey(dependency[i][0]))
                degree.put(dependency[i][0], degree.get(dependency[i][0])+1);
            else
                degree.put(dependency[i][0],1);

            if(!degree.containsKey(dependency[i][1]))
                degree.put(dependency[i][1] , 0);
        }

        for(int i : degree.keySet()){
            if(degree.get(i) == 0)
                zero.add(i);
        }


        while(!zero.isEmpty()){
            int task = zero.remove();
            result.add(task);

            for(int i = 0 ; i < dependency.length ; i++){
                if(task == dependency[i][1]){
                    degree.put(dependency[i][0] , degree.get(dependency[i][0]) -1);
                    if(degree.get(dependency[i][0]) == 0)
                        zero.add(dependency[i][0]);
                }
            }
        }

        int[] res = new int[result.size()];
        int idx = result.size();
        for(int r : result)
            res[--idx] = r;

        return res;
    }


}
