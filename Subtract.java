import java.util.ArrayList;
import java.util.*;
public class Subtract{

     public static void main(String []args){
        HelloWorld h = new HelloWorld();
        h.input();
     }
     
     public void input() {
    
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(2, c);
        ListNode e = new ListNode(1, d);
        e.print();
        subtract(e);
        e.print();
     }
     
     
     public ListNode reverse(ListNode a) {
        
         ListNode prev = null;
         ListNode curr = a;
         ListNode next ;
         while (curr != null ){
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         return prev;
     }
     
     public ListNode subtract(ListNode a) {
        ListNode slow = a;
        ListNode fast = a.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = a;
    
        ListNode secondHalf = reverse(slow.next);
        ListNode secondHead = secondHalf;
    
        while ( secondHalf!= null){
        
            firstHalf.val = secondHalf.val - firstHalf.val;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        
        }
        reverse(secondHead);
        
        return a;
     }
         
    public class ListNode {
    public int val;       // val stored in this node
    public ListNode next;  // link to next node in the list

    public ListNode() {
        this(0, null);
    }

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    public void print(){
        ListNode curr = this;
        while (curr != null ) {
            System.out .print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }
    
    }
     
}

