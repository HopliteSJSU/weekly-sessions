/**
 * Question: 76. Minimum Window Substring 
 * Link: https://leetcode.com/problems/minimum-window-substring/ 
 * Hoplite Session: 09/19/2019
 * 
 * Time Complexity: O(|s|+|t|) 
 * Space Complexity: O(1)
 * 
 * s is the input string
 * t is the target string
 * |n| denotes length of n string
 * 
 * Approach: Use Sliding window approch. We keep increasing the sliding window
 * size until we get all the characters required. As soon the condition
 * statifies, we compress the window from the left side until all the required
 * characters are still present. We track the characters in the sliding window
 * using a charFrequencyMap array and charCountLeft counter. charFrequencyMap
 * stores the frequency of the characters and counter keeps track of number of
 * characters left to be found. We change the counter based on the frequency of
 * a char in charFrequencyMap. charFrequencyMap is initialized with the freq of
 * characters in 't' or the target string. For instance when adding a character
 * to sliding window if the frequency of that char is more than 0 we decrement
 * the counter. In charFrequencyMap, we decrement the value of the char when
 * it's added in the window and vice versa. We track the mininmum window in
 * currentMinSubsStart, currentMinSubsEnd and its length in
 * currentMinSubsLength.
 * 
 * References: https://www.javatpoint.com/java-char-to-int
 * 
 */

class Solution {
    public String minWindow(String s, String t) {
        // No susbtring possible if target string is greater
        if (s.length() < t.length())
            return "";

        int windowStart = 0, windowEnd = 0;
        int currentMinSubsLength = Integer.MAX_VALUE;
        int currentMinSubsStart = 0, currentMinSubsEnd = 0;
        int charCountLeft = t.length();

        /**
         * Meant to store the freq of the required characters i.e. frequency of
         * characters in target string.
         */
        int[] charFrequencyMap = new int[128];

        // Initialized charFrequencyMap with target string's char frequency
        fillCharFrequencyMap(charFrequencyMap, t);

        for (; windowEnd < s.length(); windowEnd++) {
            char charAtWindowEnd = s.charAt(windowEnd);

            /**
             * Decrement charCountLeft if charAtWindowEnd is one of the required characters
             * from the target string
             */
            if (charFrequencyMap[charAtWindowEnd] > 0) {
                charCountLeft--;
            }
            charFrequencyMap[charAtWindowEnd]--;

            // Loop until the solution is valid and keep shortening the window from start
            while (charCountLeft == 0) {
                char charAtWindowStart = s.charAt(windowStart);

                // Store the current window if the shortest
                if (windowEnd - windowStart < currentMinSubsLength) {
                    currentMinSubsStart = windowStart;
                    currentMinSubsEnd = windowEnd;
                    currentMinSubsLength = windowEnd - windowStart;
                }

                // Remove the start char in the window
                charFrequencyMap[charAtWindowStart]++;
                if (charFrequencyMap[charAtWindowStart] > 0)
                    charCountLeft++;
                windowStart++;
            }
        }

        // currentMinSubsLength will be Integer.MAX_VALUE if no string found.
        return currentMinSubsLength == Integer.MAX_VALUE ? "" : s.substring(currentMinSubsStart, currentMinSubsEnd + 1);
    }

    void fillCharFrequencyMap(int[] charFrequencyMap, String target) {
        for (char c : target.toCharArray()) {
            charFrequencyMap[c]++;
        }
    }
}
