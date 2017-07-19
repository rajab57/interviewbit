public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    if ( a == null || a.size() < 4) return result;
	    Collections.sort(a);
	    int size = a.size();
	    for ( int i = 0; i < size-3; ++i) {
	        if ( i != 0 && a.get(i) == a.get(i-1)) continue;
	        for ( int j = i+1; j < size-2; ++j) {
	            if ( j != i+1 && a.get(j) == a.get(j-1)) continue;
	            int k = j+1;
	            int l = size-1;
	            while (k < l) {
	                int sum = a.get(i) + a.get(j) + a.get(k) + a.get(l);
	                if ( sum > b ) {
	                    --l;
	                } else if ( sum < b ) {
	                    ++k;
	                } else {
	                    ArrayList res = new ArrayList(Arrays.asList(a.get(i), a.get(j), a.get(k), a.get(l)));
	                    result.add(res);
	                    ++k; --l;
	                    while(k<l && a.get(l) == a.get(l+1) ){
                            --l;
                        }
                        while(k<l && a.get(k) == a.get(k-1)){
                            ++k;
                        }
	                }
	            } // while loop
	        } // for j
	    } // for i
	    return result; 
	}
}
