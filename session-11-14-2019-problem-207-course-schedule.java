/**
 * Question: 207. Course Schedule 
 * Link: https://leetcode.com/problems/course-schedule/ 
 * Hoplite Session: 11/14/2019
 * 
 * Time Complexity: O(V * V)
 * Space Complexity: O(E + V)
 * 
 * We use toposort to find all the possible courses that can be completed.
 * 
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] adjacencyMatrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        // Construct adjacencyMatrix and calculate indegree for every node
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            if (adjacencyMatrix[prerequisite][course] == 0) {
                indegree[course]++;
            }
            adjacencyMatrix[prerequisite][course] = 1;
        }

        Queue<Integer> queue = new LinkedList();

        /**
         * Initialize queue with courses having no prerequisites
         */
        int possibleCoursesCount = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            possibleCoursesCount++;

            /**
             * Remove current course prerequisites as a dependency from
             * other nodes and update indegree.
             */
            for (int i = 0; i < numCourses; i++) {
                if (adjacencyMatrix[currentCourse][i] != 0) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }

        }

        return possibleCoursesCount == numCourses;
    }
}
