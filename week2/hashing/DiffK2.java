import java.util.*;
public class DiffK2 {

	public static void main(String[] args) {

		List<Integer> a = Arrays.asList(1, 5, 4, 1, 2);
		List<Integer> b = Arrays.asList(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29);
		System.out.println(diffPossible(a, 0));
		System.out.println(diffPossible(b, 97));
	}
	public static int diffPossible(final List<Integer> a, int b) {
	    
	    Map<Integer, ArrayList<Integer>> locationMap = new HashMap<>();
	    for ( int i = 0; i < a.size(); ++i) {
	        ArrayList<Integer> list = locationMap.get(a.get(i));
	        if (list == null) {
	            list = new ArrayList<>();
	        }
	        list.add(i);
	        locationMap.put(a.get(i), list);
	    }
	    for ( int i = 0; i < a.size(); ++i) {
	        int firstVal = a.get(i);
	        int secondVal = firstVal -b;
		if (b == 0) secondVal = Math.abs(secondVal);
		System.out.print("firstVal: " + firstVal);
		System.out.println(" secondVal: " + secondVal);
	        ArrayList<Integer> list = locationMap.get(secondVal); 
	        if (list != null) {
	            for (Integer l : list) {
	                if ( l == i) continue;
	                return 1;
	            }
	        }
	    }
	    return 0;
	}
}

