import java.util.*;

/**
 * Created by Nikhil on 11/28/16.
 */

/**
 * Design a Phone Directory which supports the following operations:
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 */
public class PhoneDirectory {

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    private HashSet<Integer> usedNumbers = new HashSet<>();
    private Stack<Integer> releasedNumbers = new Stack<>();
    int start = 0;
    int end;

    public PhoneDirectory(int maxNumbers) {
        this.end = maxNumbers;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        int phoneNumber = -1;
        if (start < end) {
            phoneNumber = start;
            start++;
            usedNumbers.add(phoneNumber);
        } else if (!releasedNumbers.isEmpty()) {
            phoneNumber = releasedNumbers.pop();
            usedNumbers.add(phoneNumber);
        }
        return phoneNumber;

    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !usedNumbers.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (usedNumbers.contains(number)) {
            usedNumbers.remove(number);
            releasedNumbers.push(number);
        }
    }
}
