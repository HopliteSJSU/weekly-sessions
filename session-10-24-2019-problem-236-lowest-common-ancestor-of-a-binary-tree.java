/**
 * Question: 236. Lowest Common Ancestor of a Binary Tree 
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Hoplite Session: 10/24/2019
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * N is the length of input
 * 
 * Approach: In a bottom to top recursion, if current subtree contain both p and q,
 * the LCA is returned. If only one is present, that one node is returned (p or q)
 * other if both are null
 * 
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        
        if (left == null)
            return right;

        if (right == null)
            return left;

        return root;

    }
}