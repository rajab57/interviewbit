public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    int low = 0;
	    int m = a.size(); // Num rows
	    if ( m == 0) return -1;
	    int n = a.get(0).size(); // Num columns
	    if ( n == 0 ) return -1;
	    int high = m * n - 1;
	    while ( low <= high ) {
	        int mid = ( low  + high )/2;
	        int x = mid /n;
	        int y = mid - (x * n);
	        ArrayList<Integer> row  = a.get(x);
	        int val = row.get(y);
	        if ( b == val ) return 1;
	        else if ( b > val) low = mid +1;
	        else if ( b < val ) high = mid - 1;
	    }
	    return 0;
	
	}
}
