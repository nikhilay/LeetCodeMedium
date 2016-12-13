/**
 * Created by Nikhil on 12/13/16.
 */

import javax.sound.sampled.Line;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
 * you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to
 * finish all courses, return an empty array.
 */
public class CourseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            hmap.put(i, 0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            hmap.put(course, hmap.get(course) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int course : hmap.keySet()) {
            if (hmap.get(course) == 0) {
                queue.add(course);
            }
        }

        int[] result = {};
        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int queueCourse = queue.remove();
            list.add(queueCourse);

            for (int i = 0; i < prerequisites.length; i++) {
                int course = prerequisites[i][0];
                int preCourse = prerequisites[i][1];
                if (queueCourse == preCourse) {
                    hmap.put(course, hmap.get(course) - 1);
                    if (hmap.get(course) == 0) {
                        queue.add(course);
                    }
                }
            }
        }
        if (list.isEmpty() || list.size() < numCourses) return result;
        result = new int[numCourses];
        int index = 0;
        for (int i : list) {
            result[index] = i;
            index++;
        }
        return result;
    }
}
