/**
 * Question: 199. Binary Tree Right Side View 
 * Link: https://leetcode.com/problems/binary-tree-right-side-view/ 
 * Hoplite Session: 10/31/2019
 * 
 * Time Complexity: O(N) 
 * Space Complexity: O(N)
 * 
 * N is the total number nodes in the tree
 * 
 * Approach: Add first element of each level in result array. Traverse in
 * root-right-left sequence.
 * 
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        rightSideViewHelper(root, 0, result);
        return result;
    }

    public void rightSideViewHelper(TreeNode node, int cl, List<Integer> result) {
        if (node == null)
            return;

        // Check if the level is traversed for the first time.
        if (result.size() <= cl) {
            result.add(node.val);
        }

        rightSideViewHelper(node.right, cl + 1, result);
        rightSideViewHelper(node.left, cl + 1, result);
    }
}