import java.util.*;
public class Palindrome {

 class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

   public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while ( fast != null && fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        int isPalindrome = 1;
        ListNode midway = reverse(slow);
        ListNode first = A;
        ListNode second = midway;
	ListNode next = null;
        while ( first != null && second != null) {
            if (first.val != second.val) {
                isPalindrome = 0;
                break;
            }
            first = first.next;
            second = second.next;
        }
        reverse(midway);
        return isPalindrome;
    }
    
    public void print(ListNode A) {
        ListNode current = A;
        while (current != null) {
            System.out.println( current.val + " -> ");
            current = current.next;
        }
        System.out.println("\n");
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
