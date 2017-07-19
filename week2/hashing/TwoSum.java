import java.util.*;
public class TwoSum {

	public static void main(String[] args) {

	List<Integer> a = Arrays.asList( 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8);
	ArrayList<Integer> output = twoSum(a,-1);
	System.out.println(output);
	}


	public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {
	    
	    Map<Integer, ArrayList<Integer>> locationMap = new HashMap<>();
	    int n = a.size();
	    for ( int i  = 0; i < n; ++i ) {
	        ArrayList<Integer> list = locationMap.get(a.get(i));
	        if (list  == null) {
	            list = new ArrayList<>();
	        }
	        list.add(i);
	        locationMap.put(a.get(i), list);
	    }
	    int index1 = 0;
	    int index2 = Integer.MAX_VALUE;
	    for ( int i  = 0; i < n; ++i ) {
	        int secondVal = b - a.get(i);
	        ArrayList<Integer> locationList = locationMap.get(secondVal);
	        if (locationList != null) {
	            for (Integer l : locationList) {
	                if (l < index2 && i < l) {
	                    index2 = l;
	                    index1 = i;
	                    break;
	                }
	            }
	        }
	    }
	    System.out.println("index1 :" + index1  + ":" + a.get(index1));
	    System.out.println("index2 :" + index2  + ":" + a.get(index2 ));
	    int index1Val = a.get(index1);
	    for ( int i  = 0; i < n; ++i ) {
	        if (a.get(i) == index1Val && i < index1) {
	            index1 = i;
	        }
	    }
	    ArrayList<Integer> output = new ArrayList<>();
	    if ( index2 != Integer.MAX_VALUE) {
	        output.add(index1+1);
	        output.add(index2+1);
	    }
	    return output;    
	}
}

