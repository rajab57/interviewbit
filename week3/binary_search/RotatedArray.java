public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    int index = rotatedArray(a);
	    int size = a.size()-1;
	    //System.out.print("index" + index);
	    if ( index == -1) return index;
	    if ( b == a.get(index)) return index;
	    if ( b > a.get(0)) {
	        return binarySearch(a, 0, (index-1 +size )% size, b); 
	    } 
	    else if ( b < a.get(0)) {
	        return binarySearch(a,(index+1)%size, size, b); 
	  
	    }
	    return -1;
	    
	}
	
	public int binarySearch(final List<Integer> a, int low , int high, int b) {
	    while ( low <= high) {
	        int mid = (low + high)/2;
	        //System.out.print("   " + low + "::" + high+ "::" + mid);
	        if(a.get(mid) == b) return mid;
	        if (b < a.get(mid)) {
	            high = mid -1;
	        } else if ( b >= a.get(mid)) {
	            low = mid +1;
	        }
	    }
	    return -1;
	}
	public int rotatedArray(final List<Integer> a) {
	    if ( a == null || a.isEmpty()) return -1;
	    int low = 0; int high = a.size()-1;
	    while ( low <= high ) {
	       
	        int mid = (low+high)/2;
	        if (a.get(low) <= a.get(high)) return low;
	       // System.out.print("   " + low + "::" + high+ "::" + mid);
	        if (a.get(mid-1) >= a.get(mid) && a.get(mid+1) >= a.get(mid)) {
	            return mid;
	        }
	        else if(a.get(mid) <= a.get(high)) {
	            high = mid-1;
	        }
	        else if (a.get(mid) >= a.get(low)) {
	            low = mid +1;
	        }
	    }
	    return -1;
	}
}

