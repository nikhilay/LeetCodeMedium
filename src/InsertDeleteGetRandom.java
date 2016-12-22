import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Nikhil on 12/22/16.
 */

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability
 * of being returned.
 */
public class InsertDeleteGetRandom {
    /**
     * Initialize your data structure here.
     */
    HashMap<Integer, Integer> hmap;
    ArrayList<Integer> arrList;
    Random rand;

    public InsertDeleteGetRandom() {
        hmap = new HashMap<>();
        arrList = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!hmap.containsKey(val)) {
            hmap.put(val, arrList.size());
            arrList.add(val);
            return true;
        }
        return false;

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (hmap.containsKey(val)) {
            int loc = hmap.get(val);
            if (loc < arrList.size() - 1) {
                arrList.set(loc, arrList.get(arrList.size() - 1));
                hmap.put(arrList.get(arrList.size() - 1), loc);
            }
            arrList.remove(arrList.size() - 1);
            hmap.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int pos = rand.nextInt(arrList.size());
        return arrList.get(pos);
    }
}
