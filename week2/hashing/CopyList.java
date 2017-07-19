import java.util.*;
public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if ( head == null ) return null;
        HashMap<RandomListNode, RandomListNode> addressMapping = new HashMap<>();
        RandomListNode newHead = null;
        RandomListNode current = head;
        RandomListNode previous = null;
        while (current != null) {
            RandomListNode newNode = new RandomListNode(current.label);
            newNode.random = current.random;
            addressMapping.put(current, newNode);
            if ( previous != null) {
                previous.next = newNode;
            }
            previous = newNode;
            current = current.next;
        }
        
        newHead = addressMapping.get(head);
        
        // random pointers deep copy
        current = newHead;
        while(current != null) {
            if (current.random != null) {
                current.random = addressMapping.get(current.random);
            }
           current = current.next;
        }
        return newHead;
    }
}

