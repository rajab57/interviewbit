/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    ListNode head = null;
	    ListNode current = null;
	    int carryOver = 0;
	    ListNode f1 = a;
	    ListNode f2 = b;
	    while (f1 != null && f2 != null) {
	        int first = f1.val;
	        int second = f2.val;
	        int sum = first + second + carryOver;
	        int currentSum = sum % 10;
	        ListNode sumNode = new ListNode( currentSum );
	        carryOver = sum /10 ;
	        if ( current == null)   { head = sumNode; current = sumNode; } 
	        else { 
	            current.next = sumNode;
	            current = sumNode;
	        }
	        f1 = f1.next; f2 = f2.next;
	    }
	    
	    ListNode rest = null;
	    if ( f1 != null ) rest = f1;
	    else if (f2 != null ) rest = f2;
	    while (rest != null) {
	       int sum = rest.val + carryOver;
	       int currentSum = sum % 10;
	       ListNode sumNode = new ListNode( currentSum );
	       carryOver = sum /10 ;
	       if ( current == null)   { head = sumNode; current = sumNode; } 
	        else { 
	            current.next = sumNode;
	            current = sumNode;
	        }
	        rest = rest.next;
	    }
	    if ( carryOver != 0 ) {
	        ListNode carryOverNode = new ListNode(carryOver);
	        current.next = carryOverNode;
	    }
	    
	    return head;
	}
}

