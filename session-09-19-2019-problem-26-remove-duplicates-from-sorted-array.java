/**
 * Question: 26. Remove Duplicates from Sorted Array 
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/ 
 * Hoplite Session: 09/19/2019
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Approach: Use 2 pointer approach. Trail pointer will keep track of the
 * position of the next unique element and lead pointer will look for the next
 * element unique element. As soon as Lead pointer finds a new unique element we
 * overwrite it on the trail pointer and increment trail pointer. In the end
 * position of trails pointer denotes number of unique numbers.
 * 
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        // If zero or 1 number present no need to procced
        if (nums.length <= 1)
            return nums.length;

        // Pointer initialized to 1 since 0th number will always be unique
        int leadPointer = 1;
        int trailPointer = 1;

        for (; leadPointer < nums.length; leadPointer++) {
            /**
             * Keep moving leadPointer until it is more then the last unique element. Since
             * input is a sorted list next number greater than current one will also be our
             * next unique number
             */
            if (nums[leadPointer] <= nums[trailPointer - 1])
                continue;

            // Overwrite new unique number in the trailPointer position                
            nums[trailPointer] = nums[leadPointer];

            // Move trailPointer to next position for holding new unique element
            trailPointer++;
        }

        return trailPointer;
    }
}
