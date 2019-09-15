/**
 * Question: 88. Merge Sorted Array
 * Link: https://leetcode.com/problems/merge-sorted-array/
 * Hoplite Session: 09/05/2019
 * 
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * Index to last value of final merged array which is also the last element in
         * nums1 array Based on given data: m+n = nums1.length
         */
        int trail = m + n - 1;

        // Pointers to last non-zero values in the array
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;

        // While there are elements to compare in both arrays
        while (nums1Pointer >= 0 && nums2Pointer >= 0) {
            /**
             * Assign the max of 2 pointed values to the trail pointer in nums1 and
             * decrement used pointers
             */
            if (nums1[nums1Pointer] >= nums2[nums2Pointer]) {
                nums1[trail--] = nums1[nums1Pointer--];
            } else {
                nums1[trail--] = nums2[nums2Pointer--];
            }
        }

        /**
         * If nums1 is traversed and some elements in nums2 are left to be traversed,
         * move them to nums1
         */
        if (nums2Pointer >= 0) {
            while (trail >= 0 && nums2Pointer >= 0) {
                nums1[trail--] = nums2[nums2Pointer--];
            }
        }
    }
}
