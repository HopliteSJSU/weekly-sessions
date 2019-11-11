/**
 * Question: 133. Clone Graph
 * Link: https://leetcode.com/problems/clone-graph/
 * Hoplite Session: 11/07/2019
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * N total number of nodes in the graph
 * 
 * Approach: Store the cloned node in HashMap and DFS traverse the graph
 * cloning all the elements
 * 
 */

class Solution {
    // Used to track the visited nodes and their cloned nodes
    HashMap<Node, Node> visited;


    public Node cloneGraph(Node node) {
        visited = new HashMap();
        
        // Start DFS
        Node clone = cloneGraphHelper(node);

        return clone;
    }

    public Node cloneGraphHelper(Node node) {
        if (node == null)
            return null;

        // Reuse a node if already cloned
        if (visited.containsKey(node))
            return visited.get(node);

        // Clone a node when visiting for the first time
        Node newNode = new Node(node.val, new ArrayList());
        visited.put(node, newNode);

        // Clone neighbours
        for (Node c : node.neighbours) {
            Node cloneC = cloneGraphHelper(c);
            newNode.neighbours.add(cloneC);
        }

        return newNode;
    }
}
