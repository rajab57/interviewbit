//Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if ( n <=0 || k > n) return result;
	    ArrayList<Integer> item = new ArrayList<Integer>();
	    combineInternal(n, k, 1, item, result);
	    return result;
	    
	}

	private void combineInternal(int n, int k, int start, ArrayList<Integer> item , ArrayList<ArrayList<Integer>> result ) {
	    
	    if (item.size() == k) {
	        result.add(new ArrayList<Integer>(item));
	        return;
	    }
	    
	    for (int i = start; i <= n; i++ ) {
	        item.add(i);
	        combineInternal(n, k, i+1, item, result);
	        item.remove(item.size()-1);
	    }
	}
}
