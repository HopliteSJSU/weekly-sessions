/**
 * Question: 98. Validate Binary Search Tree 
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 * Hoplite Session: 10/24/2019
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * N is number of elements in the tree
 * 
 * Approach: Use a lower and higher bound for every node. Update these
 * bounds while traversing the tree.
 * 
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if (root == null)
            return true;

        // Lower and Higher bound for a node.
        TreeNode min = null;
        TreeNode max = null;
        
        // Start with root node with no bounds
        return isValidBST(root, min, max);
    }

    boolean isValidBST(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null)
            return true;
        
        // Less than lower bound
        if (min != null && node.val <= min.val)
            return false;
        
        // Greater then higher bound
        if (max != null && node.val >= max.val)
            return false;

        // change bounds for left and right child nodes
        return isValidBST(node.left, min, node) 
            && isValidBST(node.right, node, max);
    }
}
