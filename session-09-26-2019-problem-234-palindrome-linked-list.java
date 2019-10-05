/**
 * Question: 234. Palindrome Linked List
 * Link: https://leetcode.com/problems/palindrome-linked-list
 * Hoplite Session: 09/26/2019
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Approach: Find the middle. Reverse the other half (from middle element). 
 * Compare both the halves. If both are equal then its a palindrome.
 * 
 */

class Solution {
    
    public boolean isPalindrome(ListNode head) {
        
        ListNode fast = head, slow = head;

        /**
         * We find the middle using slow-fast pointer approach. Fast pointer moves 2
         * steps and slow moves 1 when fast reaches the end. Slow will be in the middle.
         */
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // If there are odd number of nodes shift middle
        if (fast != null) {
            slow = slow.next;
        }

        // Reverse elements from the middle node
        ListNode mid = reverse(slow);

        // Compare both the partition
        while (mid != null) {
            if (head.val != mid.val) {
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }

    // Reverses the Linkedlist
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
