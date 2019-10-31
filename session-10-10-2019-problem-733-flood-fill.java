/**
 * Question: 733. Flood Fill
 * Link: https://leetcode.com/problems/flood-fill/
 * Hoplite Session: 10/10/2019
 * 
 * Time Complexity: O(N) 
 * Space Complexity: O(N)
 * 
 * N is the number of elements
 * 
 * Approach: DFS from the starting element and keep moving forward change 
 * color in all the direction untill an invalid color is reached.
 * 
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        // DFS from the starting node
        dfs(image, sr, sc, image[sr][sc], newColor);

        return image;
    }

    void dfs(int[][] image, int row, int col, int o, int n) {

        // Check for invalid row and col and if already colored
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != o) {
            return;
        }

        // Change the color
        image[row][col] = n;

        // Move to next color up, down, left and right
        dfs(image, row + 1, col, o, n);
        dfs(image, row - 1, col, o, n);
        dfs(image, row, col + 1, o, n);
        dfs(image, row, col - 1, o, n);

    }
}