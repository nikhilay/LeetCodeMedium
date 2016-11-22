import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Nikhil on 11/21/16.
 */

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        int[] indegree = new int[numCourses];
        List<Integer>[] matrix = new LinkedList[numCourses];
        for (int[] row : prerequisites) {
            int preCourse = row[1];
            int readyCourse = row[0];
            List<Integer> list = matrix[preCourse];
            if (list == null) {
                list = new LinkedList<>();
                matrix[preCourse] = list;
            }
            list.add(readyCourse);
            indegree[readyCourse]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            count++;
            List<Integer> list = matrix[vertex];
            if (list == null) continue;
            for (int course : list) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.add(course);
                }
            }

        }

        return count == numCourses;
    }
}
