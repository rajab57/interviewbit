import java.util.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Partition {
	public ListNode partition(ListNode a, int b) {
	    if ( a == null ) return a;
	    ListNode lessNode = null;
	    ListNode lastLessNode = null;
	    ListNode greaterNode = null;
	    ListNode lastGreaterNode = null;
	    ListNode current = a;
	    ListNode next = null;
	    while ( current != null) {
	        next = current.next;
	        if (current.val < b) {
	            if ( lessNode != null ) {
	                lastLessNode.next = current;
	            } else {
	                lessNode = current;
	            }
	            current.next = null;
	            lastLessNode = current;
	        } else {
	            if (greaterNode != null) {
	                lastGreaterNode.next = current;
	            } else {
	                greaterNode = current;
	            }
	            current.next = null;
	            lastGreaterNode = current;
	        }
	        current = next;
	    }
	    if (lastLessNode != null) lastLessNode.next = greaterNode;
	    else lessNode = greaterNode;
	    return lessNode;
    }
}

