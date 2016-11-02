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
        int startTime;
        int endTime;

        Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Interval i = new Interval(1,2);
        Interval j = new Interval(2,3);
        Interval k = new Interval(3,4);
        Interval[] input = {j,i,k,i};
        new MeetingRoomsTwo().minMeetingRooms(input);
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.startTime - o2.startTime > 0) {
                    return 1;
                } else if (o1.startTime - o2.startTime < 0) {
                    return -1;
                } else {
                    if (o1.endTime - o2.endTime > 0) {
                        return 1;
                    } else if (o1.endTime - o2.endTime < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].startTime < intervals[i - 1].endTime) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
