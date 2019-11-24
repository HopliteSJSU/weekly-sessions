/**
 * Question: 78. Subsets
 * Link: https://leetcode.com/problems/subsets/ 
 * Hoplite Session: 11/21/2019
 * 
 * Time Complexity: O(N * 2^N) 
 * Space Complexity: O(N)
 * 
 * N is the length of nums.
 * 
 * Approach is to backtrack while storing all the combination
 * 
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, nums, 0, new ArrayList());
        return result;
    }

    void backtrack(List<List<Integer>> result, int[] num, int index, List<Integer> current) {
        // Add current collection as a solution
        result.add(new ArrayList<Integer>(current));

        for (int i = index; i < num.length; i++) {
            // Add next possible number
            current.add(num[i]);
            backtrack(result, num, i + 1, current);
            // Remove the added number
            current.remove(current.size() - 1);
        }
    }
}
