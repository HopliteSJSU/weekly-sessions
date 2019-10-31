/**
 * Question: 48. Rotate Image
 * Link: https://leetcode.com/problems/rotate-image/
 * Hoplite Session: 10/17/2019
 * 
 * Time Complexity: O(N) 
 * Space Complexity: O(1)
 * 
 * N is the number of elements in the matrix
 * 
 * Approach: Start from corner, swap them.
 * 
 */

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // Swapping matrix values
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}
