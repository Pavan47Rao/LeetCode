/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */

package Medium;
import java.util.*;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dict = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] prereq: prerequisites) {
            if(dict.containsKey(prereq[1])) {
                dict.get(prereq[1]).add(prereq[0]);
            }
            else {
                List<Integer> courses = new LinkedList<>();
                courses.add(prereq[0]);
                dict.put(prereq[1], courses);
            }
            indegree[prereq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(indegree[i] == 0)
                queue.add(i);
        int count = 0;
        while(!queue.isEmpty()) {
            Integer node = queue.peek();
            queue.poll();
            count++;
            if(dict.containsKey(node)) {
                for(Integer dependency: dict.get(node)) {
                    indegree[dependency]--;
                    if(indegree[dependency] == 0)
                        queue.add(dependency);
                }
            }
        }
        return count == numCourses;
      }

      public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        if(canFinish(numCourses, prerequisites))
            System.out.println("Courses can be finished!");
        else
            System.out.println("Courses can't be finished!");
      }
}
