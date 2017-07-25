/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode rotateRight(ListNode a, int b) {
	    if ( a == null ) return null;
	    if (a.next == null) return a;
	    ListNode current = a;
	    ListNode head = a;
	    int count = 1;
	    while (current.next != null) {
	        current = current.next;
	        ++count;
	    }
	        // create a cycle
	        current.next = a;
	        ListNode tail  = current;
	        current = head;
	        int index = 1;
	        int end = Math.abs(count - b%count );
	        while ( index < end  ) {
	            current = current.next;
	            ++index;
	        }
	        head = current.next;
	        current.next = null;
	   
	    return head;
	}
}

