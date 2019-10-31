/**
 * Question: 328. Odd Even Linked List 
 * Link: https://leetcode.com/problems/odd-even-linked-list/ 
 * Hoplite Session: 10/17/2019
 * 
 * Time Complexity: O(N) 
 * Space Complexity: O(1)
 * 
 * N is the length of linkedlist
 * 
 * Approach: Use 3 pointers to keep track of odd elements,
 * even elements and head of even elements. Seperate odd and
 * even elements and connect.
 * 
 */

public class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return null;

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
