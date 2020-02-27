/**
 * Question: 167. Two Sum II - Input array is sorted 
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Hoplite Session: 02/25/2020
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(1)
 * 
 * Since the list is sorted, we can use two pointers. Move the end pointer
 * left is their sum is greater than target and vice versa.
 * 
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Init start and end pointers
        int start = 0, end = numbers.length - 1;

        // Start and End pointers should not overlap and cross each other
        while (start < end) {
            int currentSum = numbers[start] + numbers[end];

            // target found
            if (currentSum == target) {
                // +1 to index since the indexes required are not zero-based
                return new int[] { start + 1, end + 1 };
            } else if (currentSum > target) {
                end--;
            } else {
                start++;
            }

        }

        // Empty array when no result found
        return new int[0];
    }
}
