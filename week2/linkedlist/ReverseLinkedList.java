import java.util.*;
public class ReverseLinkedList {
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    int index = 1;
	    ListNode current = a;
	    ListNode prev = null;
	    ListNode b = null;
	    ListNode next = null;
	    if ( m >= n || m ==n ) return a;
	    while ( current != null) {
	        next = current.next;
	        if ( index == m)  {
	            b = reverse(current,  m, n);
	            break;
	        }
	        prev = current;
	        current = current.next;
	        ++index;
	    }
	    if ( b != null) {
	        if (prev != null) prev.next = b;
	    }
	    if (m == 1 ) return b;
	    return a;
	}
	
	public void print(ListNode A) {
        ListNode current = A;
        while (current != null) {
            System.out.print( current.val + " -> ");
            current = current.next;
        }
        System.out.print("\n");
    }
	
	public ListNode reverse(ListNode a, int m, int n) {
	    ListNode current = a;
	    ListNode prev = null;
	    ListNode next = null;
	    int count = m;
	    while (current != null && m <= n) {
	        next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
	        ++m;
	    }
	    a.next = current;
	    return prev;
	}
}
