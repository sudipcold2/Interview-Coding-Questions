package questions.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also
 * have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0)
            return true;

        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] visited = new int[numCourses];

        for(int i=0; i < numCourses; i++) {
            if (!dfs( i, courses, visited))
                return false;
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

        visited[course] = 1;

        List<Integer> eligibleCourses = courses.get(course);

        for (Integer eligibleCourse : eligibleCourses) {
            if (visited[eligibleCourse] == 1)
                return false;
            if (visited[eligibleCourse] == 0) {
                if (!dfs(eligibleCourse, courses, visited))
                    return false;
            }
        }

        visited[course] = 2;
        return true;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }

        return count == numCourses;
    }
}

