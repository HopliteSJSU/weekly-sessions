/**
 * Question: 785. Is Graph Bipartite?
 * Link: https://leetcode.com/problems/is-graph-bipartite/ 
 * Hoplite Session: 11/07/2019
 * 
 * Time Complexity: O(N + E)
 * Space Complexity: O(N)
 * 
 * N is the number of nodes in the graph, and E is the number of edges
 * 
 * Approach: Color nodes in graph. For instance, If a node is red
 * colored, color its neighbouring node as black and vice versa. In a case 
 * where a neighbouring is already colored and its same as current node
 * that means the graph is not bipartited.
 * 
 */

class Solution {
    public boolean isBipartite(int[][] graph) {
        // Store color for a node, 1 and -1. Default if uncolored.
        int[] color = new int[graph.length];

        // Start BFS from uncolored nodes
        for (int start = 0; start < graph.length; start++) {
            if (color[start] != 0)
                continue;

            Stack<Integer> stack = new Stack();
            stack.add(start);

            // Color starting node
            color[start] = 1;

            while (!stack.isEmpty()) {

                int currentNode = stack.pop();

                for (int n = 0; n < graph[currentNode].length; n++) {
                    int neighbour = graph[currentNode][n];
                    
                    /**
                     * If Node is uncolored, color it with complement
                     * of current node
                     */
                    if (color[neighbour] == 0) {
                        color[neighbour] = color[currentNode] == 1 ? -1 : 1;
                        stack.add(neighbour);
                    } else if (color[neighbour] == color[currentNode]) {
                        return false;
                    }
                }

            }
        }
        
        return true;
    }
}
