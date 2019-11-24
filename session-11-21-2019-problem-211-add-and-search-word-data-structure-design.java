/**
 * Question: 211. Add and Search Word - Data structure design 
 * Link: https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * Hoplite Session: 11/21/2019
 * 
 * addWord()
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * N is the length of word.
 * 
 * search()
 * Time Complexity: O(M)
 * Space Complexity: O(M)
 * 
 * M is the length of all the words in the Trie.
 * 
 * Create a Trie, with a boolean in the node structure to define it's work.
 * In case of a '.' check with all the following words if there's a match.
 * 
 */

class WordDictionary {
    private class Node {
        public boolean isWord;
        public HashMap<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
        size = 0;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null)
                current.next.put(c, new Node());
            current = current.next.get(c);
        }
        if (!current.isWord) {
            current.isWord = true;
            size++;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length())
            return node.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null)
                return false;
            return match(node.next.get(c), word, index + 1);
        } else {
            // Try `.` as any of the following word and try to match.
            for (char nextChar : node.next.keySet())
                if (match(node.next.get(nextChar), word, index + 1))
                    return true;
            return false;
        }
    }
}