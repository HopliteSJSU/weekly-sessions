/**
 * Question: 56. Merge Intervals 
 * Link: https://leetcode.com/problems/merge-intervals/
 * Hoplite Session: 09/12/2019
 * 
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sorting the intervals
        sortInterval(intervals);

        // Stack with smallest start time interval
        Stack<int[]> result = new Stack();
        result.push(intervals[0]);

        // Loop from 2nd interval to merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            // Intervals does not overlap
            if (intervals[i][0] > result.peek()[1]) {
                result.add(intervals[i]);
            }
            // Intervals overlap
            else {
                int[] temp = result.pop();
                // Merge intervals with end index as max of both
                temp[1] = Math.max(temp[1], intervals[i][1]);
                result.push(temp);
            }
        }

        /**
         * Convert stack into array Read more:
         * https://docs.oracle.com/javase/7/docs/api/java/util/Vector.html#toArray(T[])
         */
        return result.toArray(new int[result.size()][]);
    }

    private void sortInterval(int[][] intervals) {
        /**
         * Sorting intervals with lamda comparators Read more:
         * https://www.mkyong.com/java8/java-8-lambda-comparator-example/
         */
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    }
}
