/**
 * Question: 11. Container With Most Water 
 * Link: https://leetcode.com/problems/container-with-most-water/ 
 * Hoplite Session: 02/25/2020
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Since the water that can fit in a container restricted by the smaller of the
 * two walls. We use 2-pointers to maximize the area. We do this by moving the
 * start and end pointer based on the height of the wall, smaller of the 2 walls
 * are moved (pointer is moved). Calculate area at every combination Start and
 * end that occurs, find the max area from all the areas calculated.
 * 
 */

class Solution {
    public int maxArea(int[] height) {

        int maxAreaTillNow = 0;

        // Init trail and lead pointers
        int start = 0, end = height.length - 1;

        // Start and End pointers should not overlap and cross each other
        while (start < end) {

            /**
             * The area is calculated considering current 'start' and 'end' pointers as
             * container walls. Water that fit in the container can be determined by the
             * smaller wall. Therefore the area is the product of distance between walls and
             * the height of the smaller wall
             */
            int startToEndArea = (end - start) * Math.min(height[start], height[end]);

            // To get the largest of all the 'startToEndArea'
            maxAreaTillNow = Math.max(maxAreaTillNow, startToEndArea);

            // Move the pointer associated with the smaller of the 2 walls
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }

        }

        return maxAreaTillNow;
    }
}
