public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    if (a == null || a.isEmpty()) return 0;
	    int low = 0;
	    int high = a.size()-1;
	    int N = a.size()-1;
	    while(low <= high) {
	        if (b < a.get(low)) return (low + N)%N;
	        if (b > a.get(high)) return high+1;
	        int mid = (low+high)/2;
	        if ( b == a.get(mid)) return mid;
	        if ( b > a.get(mid)) low = mid +1;
	        if ( b < a.get(mid)) high = mid -1;
	    }
	    return 0;
	}
}
