import java.util.*;
public class MissingPositive {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		int result = firstMissingPositive(a);
		System.out.println("result " + result);
	}
	public static int firstMissingPositive(ArrayList<Integer> a) {
	   
	    int min = Integer.MAX_VALUE;
	    int max = 0;
	    int size = a.size() ; // something big
	    // turn all negative #s to zero
	    for (int i = 0; i < a.size(); ++i){
	        int num = a.get(i);
	       if (num < 0){
	           a.set(i, 2*size);
	       } else {
	           min = num < min ? num : min;
	           max = num > max ? num : max;
	       
	       } 
	    }
	    System.out.println("min " + min);	    
	    if ( min > 1 ) {
	        return 1;
	    }
	   
	 
	    for (int i = 0; i < a.size(); ++i){
	        int num = a.get(i);
	       if (num != 2*size) {
	           int val = Math.abs(num);
	           if (val > 0 && val <= a.size()) {
	               int val2 = a.get(val-1);
	               a.set(val-1, -val2);
	           }
	       }
	    }
	    for (int i = 0; i < a.size(); ++i) {
		System.out.println(a.get(i));
	    }
	    for (int i = 0; i < a.size(); ++i) {
	        int num = a.get(i);
	        if ( num > 0) {
	            return i+1;
	        }
	    }
	    return max+1;
	}
}
