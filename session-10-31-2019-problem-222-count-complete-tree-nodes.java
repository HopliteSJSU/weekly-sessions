/**
 * Question: 222. Count Complete Tree Nodes
 * Link: https://leetcode.com/problems/count-complete-tree-nodes/
 * Hoplite Session: 10/31/2019
 * 
 * Time Complexity: O(log N * log N)
 * Space Complexity: O(1)
 * 
 * N total number of nodes in the input tree
 * 
 * Approach: isPresent() function will check if the index is present.
 * Index value is converted from integer into binary representation.
 * Later used as path to the node.
 * 
 * Find the depth of tree. Use it to find smallest index and largest
 * possible index in the last row. Do a binary search to check if the
 * middle element is present using the isPresent() function.
 * 
 */

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int depth = 0;
        TreeNode node = root;

        // Find depth of the tree
        while (node != null) {
            node = node.left;
            depth++;
        }

        // Low is index of left most node in complete binary tree
        int low = (int) Math.pow(2, depth - 1);

        /**
         * High is index of the right most node in complete binary
         * tree, if last row was completely filled
         */
        int high = (int) Math.pow(2, depth) - 1;

        // Check if high node is present
        if (isPresent(root, high))
            return high;

        // Binary search between low to high
        while (low < high && high - low > 1) {
            int mid = (int) (low + high) / 2;
            // check if the mid index present in the tree
            if (isPresent(root, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private boolean isPresent(TreeNode node, int n) {
        /**
         * Binary representation of the index will be used to determine
         * the path to the given index. '1' for right & '0' for left
         *  `toBinaryString() is a log(n) function
         */
        String path = Integer.toBinaryString(n);

        // Follow the path
        for (int i = 1; i < path.length() && node != null; i++) {
            node = path.charAt(i) == '1' ? node.right : node.left;
        }

        return node != null;
    }
}