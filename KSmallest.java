// CheckPoint 3 Kth Smallest Element in the ArrayBookmark Suggest Edit

import java.util.*;
public class KSmallest{

     public static void main(String []args){
    
        List<Integer> a = new ArrayList<>();
        a.add(4); a.add(5); a.add(3); a.add(1); a.add(2);
        int result = kthsmallest(a, 2);
        System.out.println(result);
     }
     
     public static int kthsmallest(final List<Integer> a, int k) {
	    if ( a == null || a.size() < k) {
	        return -1;
	    }
	    List<Integer> newList = new ArrayList<>(a);
	    Collections.sort(newList);
	    return newList.get(k-1);
	 }
}
