/**
 * Question: 399. Evaluate Division
 * Link: https://leetcode.com/problems/evaluate-division/ 
 * Hoplite Session: 11/14/2019
 * 
 * Time Complexity: O(K * E)
 * Space Complexity: O(E)
 * 
 * K is the number of queries, and E is the number of edges
 * 
 * Approach: 
 * (a/b) x (b/c) x (c/d) = a/d
 * We use this property to find a/d. This can be done by finding a path between
 * a to d and evaluating the division on the way.
 * 
 * We find a path by creating a weighted graph. For eg. if 'a/b = 2' we store an edge from
 * a to b with a value 2 and an edge from b to a with value 1/2. 
 * 
 */

class Solution {
    class Node {
        public String val;
        HashMap<Node, Double> next;
        Node(String val){
            this.val = val;
            next = new HashMap();
        }
        private void addEdge(Node dest, Double cost){
            next.put(dest, cost);
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];

        // Build a map from the equations and values we have in input. 
        HashMap<String, Node> map = new HashMap();  
        for(int i = 0; i < equations.length; i++) {
            String src = equations[i][0];
            String dest = equations[i][1];
            Node srcNode = !map.containsKey(src) ? new Node(src) : map.get(src);
            Node destNode;
            if(!map.containsKey(dest)){
                destNode = new Node(dest);
                map.put(dest, destNode);
            } else {
                destNode = map.get(dest);
            }
            // For 'a' and 'b'. Add the value of 'a/b'
            srcNode.addEdge(destNode, values[i]);
            map.put(src, srcNode);
            
            // For 'a' and 'b'. Also add the value of 'b/a'
            destNode.addEdge(srcNode, 1/values[i]);
            map.put(dest, destNode);
        }
        
        for(int i = 0; i < queries.length; i++) {
            String opr1 = queries[i][0];
            String opr2 = queries[i][1];
            if(!map.containsKey(opr1)||!map.containsKey(opr2)) {
                result[i] = -1;
                continue;
            }
            if(opr1.equals(opr2)) {
                result[i] = 1;
                continue;
            }
            // If result not already find the value
            result[i] = findDiv(map.get(opr1), map.get(opr2));
        }
        return result;
    }

    private HashSet<Node> visited;
    private double findDiv(Node src, Node dest){
        if(src.next.containsKey(dest)){
            return src.next.get(dest);
        }
        visited = new HashSet();
        // Start DFS while calculating the division along the way
        double division = findingDest(src, dest);
        return division;
    }
    
    private double findingDest(Node src, Node dest) {        
        if(visited.contains(src)) return -1;
        if(src.next.containsKey(dest)){
            return src.next.get(dest);
        }
        visited.add(src);
        double div = -1;
        for(Map.Entry<Node, Double> e : src.next.entrySet()){
            Node n1 = e.getKey();
            double d = findingDest(n1, dest);
            if(d==-1) continue;
            div = d * e.getValue();
            break;
        }
        return div;
    }
}