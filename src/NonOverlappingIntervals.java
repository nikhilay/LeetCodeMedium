/**
 * Created by Nikhil on 11/20/16.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals,
 * find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/65584/java-o-nlogn-very-easy-solution
 * [ [1,4], [2,3], [3,4] ], the interval with early start might be very long and incompatible with many intervals.
 * But if we choose the interval that ends early, we'll have more space left to accommodate more intervals. Hope it helps.
 */
public class NonOverlappingIntervals {
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

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int count = 1;
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[last].end <= intervals[i].start) {
                count++;
                last = i;
            }
        }
        return intervals.length - count;
    }
}
