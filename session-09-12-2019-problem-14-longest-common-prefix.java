/**
 * Question: 14. Longest Common Prefix
 * Link: https://leetcode.com/problems/longest-common-prefix/
 * Hoplite Session: 09/12/2019
 * 
 * Time Complexity: O(S) 
 * Space Complexity: O(1)
 * 
 * Approach: Iterate through all the string with first string at current
 * currentPrefix. Find the longest common currentPrefix between the current
 * currentPrefix and the current string. After completing the iterations the
 * current currentPrefix will be the longest common currentPrefix.
 * 
 */

class Solution {
    public String longestCommonPrefix(String[] inputStringArray) {
        // If there are no string in the input array return ""
        if (inputStringArray.length == 0)
            return "";

        // Set first string as current longest common prefix
        String currentPrefix = inputStringArray[0];

        // Loop through all the strings, starting from the second string
        for (int i = 1; i < inputStringArray.length; i++)

            /**
             * Calculate common prefix between current prefix and current string by removing
             * last char from the currentPrefix until the currentPrefix is not the current
             * string
             */
            while (inputStringArray[i].indexOf(currentPrefix) != 0) {

                // Remove the last char from current prefix
                currentPrefix = currentPrefix.substring(0, currentPrefix.length() - 1);

                // If there's nothing common return ""
                if (currentPrefix.isEmpty())
                    return "";
            }

        // currentPrefix in the end is the longest common prefix
        return currentPrefix;
    }
}
