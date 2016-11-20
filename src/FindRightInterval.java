import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import static java.util.Arrays.binarySearch;

/**
 * Created by Nikhil on 10/31/16.
 */

/**
 * Given a set of intervals, for each of the interval i,
 * check if there exists an interval j whose start point is bigger
 * than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * For any interval i, you need to store the minimum interval j's index, which means that the interval
 * j has the minimum start point to build the "right" relationship for interval i.
 * If the interval j doesn't exist, store -1 for the interval i.
 * Finally, you need output the stored value of each interval as an array.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/67399/java-concise-binary-search
 */
public class FindRightInterval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        if (intervals == null || intervals.length == 0) return result;
        int[] startList = new int[intervals.length];
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            index.put(intervals[i].start, i);
            startList[i] = intervals[i].start;

        }
        Arrays.sort(startList);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i].end;
            int start= search(startList, end);
            if (start >= end) {
                result[i] = index.get(end);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    private int search(int[] startList, int target) {
        int low = 0;
        int high = startList.length - 1;
        while(low<high){
            int mid = low +(high-low)/2;
            if(startList[mid]<target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return startList[low];
    }


}
