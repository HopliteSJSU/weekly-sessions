/**
 * Question: 340. Longest Substring with At Most K Distinct Characters 
 * Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Hoplite Session: 09/12/2019
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(k)
 * 
 * Approach: Use a sliding window. Keep expanding the lead pointer of the window
 * until the number of unique characters is not greater than k. Calculate the
 * subtring length. Compare and store the current maximum substring length.
 * Inorder to calcuate the number of unique characters in a window, use a
 * hashmap which stores the latest index of a certain character. When the trail
 * pointer is equals to the latest index it implies that it is the last
 * occurence of that character and once the trail pointer is incremented the
 * element should be deleted from the hashmap (Alternate way would be to keep
 * record of the char frequency). In the end, return the current longest
 * substring length.
 * 
 */

class Solution {
    public int lengthOfLongestSubstringKDistinct(String inputString, int k) {

        // HashMap to store the latest index of all the unique characters
        HashMap<Character, Integer> charLatestIndex = new HashMap();

        int currentLongestSubstringLength = 0;

        // Start the sliding window with trail and lead at 0
        for (int trail = 0, lead = 0; lead < inputString.length(); lead++) {
            char currentChar = inputString.charAt(lead);

            // Store the current index i.e. the latest index of a char
            charLatestIndex.put(currentChar, lead);

            /**
             * Keep moving the trail pointer until number of unique char in the window is
             * greater than k
             */
            while (charLatestIndex.size() > k) {
                char x = inputString.charAt(trail);

                /**
                 * If the current index of the character is equal to the latest index, implies
                 * that the current occurence is the last occurence. therefore delete it from
                 * the hashmap.
                 */
                if (trail == charLatestIndex.get(x)) {
                    charLatestIndex.remove(x);
                }

                trail++;
            }

            /**
             * Since the current substring has less than k unique characters calcuate the
             * current subtring length and compare it with the current longest
             */
            currentLongestSubstringLength = Math.max(currentLongestSubstringLength, lead - trail + 1);
        }
        return currentLongestSubstringLength;
    }
}
