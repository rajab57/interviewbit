import java.util.*;
public class NbyThree {
	 public static void main(String []args){
	List<Integer> a = Arrays.asList(1);
	 int result = repeatedNumber(a);
	 System.out.println(result);
	 }
	// DO NOT MODIFY THE LIST
	public static int repeatedNumber(final List<Integer> a) {
		if ( a == null || a.isEmpty()) {
	        return -1;
	    }
	    int expectedSize = a.size()/3;
	    Integer index1 = null;
	    Integer index2 = null;
	    int count1 = 0;
	    int count2 = 0;
	    for ( int i = 0; i < a.size(); ++i) {
	        if ((index1 != null)  && a.get(index1).intValue() == a.get(i).intValue()) {
	            ++count1;
	        } else if ((index2 != null) && a.get(index2).intValue() == a.get(i).intValue()) {
	            ++count2;
	        } else if ( count1 == 0 ) {
	            index1 = i;
	            count1 = 1;
	        } else if ( count2 == 0) {
	            index2 = i;
	            count2 = 1;
	        } else {
	            --count1;
	            --count2;
	        }
	    }
	    // Major value is a[index]
	    count1 = 0; count2 = 0;
	    System.out.println(index1); 
	    for ( int i = 0; i < a.size(); ++i) {
	        if (index1 != null && a.get(i).intValue() == a.get(index1).intValue()) ++count1;
	        else if(index2 != null &&  a.get(i).intValue() == a.get(index2).intValue()) ++count2;
	    }
	    if (count1 > 0 && count1 > expectedSize) return a.get(index1).intValue();
	    if (count2 > 0 && count2 > expectedSize) return a.get(index2).intValue();
	    return -1;
	}
}
