public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    if ( a == null || a.isEmpty()) return new ArrayList(Arrays.asList(1,1));
	    int start = binarySearch(a, b, true);
	    int end = binarySearch(a, b, false);
	    ArrayList<Integer> result = new ArrayList<>();
	    result.add(start); 
	    result.add(end);
	    return result;
	}
	
	
	public int binarySearch(final List<Integer> a , int b, boolean searchFirst) {
	    int low = 0;
	    int high = a.size()-1;
	    int N = a.size();
	    int result = -1;
	    while ( low <= high) {
	        int mid = (low + high)/2;
	        if ( b == a.get(mid)) {
	            result = mid;
	            if(searchFirst) high = mid -1;
	            else low = mid + 1;
	        }
	        else if ( b < a.get(mid)) high = mid - 1;
	        else if ( b > a.get(mid)) low = mid + 1;
	    }
	    return result;
	}
}

