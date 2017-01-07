/**
 * Created by Nikhil on 11/2/16.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */
public class MeetingRoomsTwo {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) return intervals.length;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int numRooms = 0;
        int endItr = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[endItr]) {
                numRooms++;
            } else {
                endItr++;
            }

        }
        return numRooms;

    }
}
