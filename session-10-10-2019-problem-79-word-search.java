/**
 * Question: 79. Word Search
 * Link: https://leetcode.com/problems/word-search/
 * Hoplite Session: 10/10/2019
 * 
 * Time Complexity: O(row * col * (4 * word_length)) 
 * Space Complexity: O(row * col * (4 * word_length))
 * 
 * Approach: Traverse the matrix. As soon as first element is matched. DFS from
 * that character.
 * 
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null
                || word.length() == 0)
            return false;

        // 2D array to track if the char is visited. Helps in avoiding infinite loops.
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, word, row, col, 0, isVisited))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] isVisited) {
        // Completed the entire word. i.e. word found.
        if (word.length() == index)
            return true;

        // Check if the row and col are valid
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)
                || isVisited[row][col])
            return false;

        // Mark current word as visited
        isVisited[row][col] = true;

        // Move to next element on left, right, top and bottom
        boolean res = dfs(board, word, row + 1, col, index + 1, isVisited)
                || dfs(board, word, row - 1, col, index + 1, isVisited)
                || dfs(board, word, row, col + 1, index + 1, isVisited)
                || dfs(board, word, row, col - 1, index + 1, isVisited);

        // Unmark the visited character.
        isVisited[row][col] = false;

        return res;
    }
}
