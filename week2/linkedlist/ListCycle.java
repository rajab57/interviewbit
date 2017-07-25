/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    if ( a == null || a.next == null ) return null;
	    ListNode slow = a;
	    ListNode fast = a;
	    while (fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if (slow == fast ) {
	            slow = a;
	            while (slow != fast) {
	                slow = slow.next;
	                fast = fast.next;
	            }
	            return slow;
	        }
	    }
	    
	    return null;
	}
}
