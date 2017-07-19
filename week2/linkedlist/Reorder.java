import java.util.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Reorder {
	public ListNode reorderList(ListNode a) {
	    ListNode slow = a;
	    ListNode fast = a;
	    while( fast != null && fast.next != null && fast.next.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	  
	    ListNode b = reverse(slow);
	    // b is now the last node reversed
	    // slow is midway
	    // a is the begining.
	    ListNode current = a;
	    ListNode next = a.next;
	    ListNode bCurrent = b;
	    ListNode bNext = b.next;

	    while ( current != null && b != null) {
	        next = current.next;
	        current.next = bCurrent;
	        bNext = bCurrent.next;
	        bCurrent.next = next;
	        bCurrent = bNext;
	        current = next;
	    }
	    
	    return a;
	}
	
	public ListNode reverse(ListNode A) {
	    ListNode current = A ;
        ListNode prev = null;
        ListNode next = null;
        while ( current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
