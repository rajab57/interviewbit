// CheckPoint 5 : All Unique Permutations
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    if (a  == null || a.isEmpty()) {
	        return null;
	    }
	   Set<ArrayList<Integer>> uniqueSet = new HashSet<>();
	   ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	   permute(uniqueSet, a, 0, a.size()-1);
	   for (ArrayList<Integer> value: uniqueSet) {
	   
	       result.add(value);
	   }
	   return result;
	}
	
	public void permute(Set<ArrayList<Integer>> result, ArrayList<Integer>a, int l, int r) {
	    if ( l == r) {
	        result.add((ArrayList)a.clone());
	       
	    } else {
	        for ( int i = l ; i <=r; i++){
	            swap(a, l, i);
	            permute(result, a, l+1, r);
	            swap(a, l, i);
	        }
	    }
	}
	
	public void swap(ArrayList<Integer>a, int i, int j ) {
	    int tmp = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, tmp);
	}
}
