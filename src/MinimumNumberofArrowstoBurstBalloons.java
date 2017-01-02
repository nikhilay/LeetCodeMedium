/**
 * Created by Nikhil on 11/20/16.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter.
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and
 * end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with
 * xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number
 * of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to
 * find the minimum number of arrows that must be shot to burst all balloons.
 */

/**
 * Inspired from https://discuss.leetcode.com/topic/66548/concise-java-solution-tracking-the-end-of-overlapping-intervals
 */
public class MinimumNumberofArrowstoBurstBalloons {
    class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int findMinArrowShots(int[][] points) {
        if(points==null ||points.length==0 ||points[0].length==0) return 0;
        Node[] input = new Node[points.length];
        for (int i = 0; i < points.length; i++) {
            input[i] = new Node(points[i][0], points[i][1]);
        }
        Arrays.sort(input, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x-o2.x>0){
                    return 1;
                }else if(o1.x-o2.x<0){
                    return -1;
                }else{
                    if(o1.y-o2.y>0){
                        return 1;
                    }else if(o1.y-o2.y<0){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        int arrows = 1;
        int end = input[0].y;
        for (int i = 1; i < input.length - 1; i++) {
            if(input[i].x>end){
                arrows++;
                end = input[i].y;
            }else{
                end = Math.min(end,input[i].y);
            }
        }
      return arrows;
    }
}
