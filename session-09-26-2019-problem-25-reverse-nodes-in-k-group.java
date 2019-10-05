/**
 * Question: 25. Reverse Nodes in k-Group 
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/ 
 * Hoplite Session: 09/26/2019
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Approach: Use 2 pointers. Move lead pointer to kth element.
 * Reverse the element between trail and lead pointer. Keep moving.
 * 
 */

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;

        /**
         * Head of orginal LinkedList will be relocated, therefore using dummy head to
         * track
         */
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode start = dummyhead;

        int i = 0;
        while (head != null) {
            i++;
            // Reverse for every kth element. Otherwise proceed.
            if (i % k == 0) {
                start = reverse(start, head.next);
                head = start.next;
            } else {
                head = head.next;
            }
        }

        // next of dummyhead is the new head
        return dummyhead.next;

    }

    // reverse a portion of linked list given start and end
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start.next;
        ListNode next, first;
        ListNode prev = start;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }

}