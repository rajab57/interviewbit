public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	   
	   ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	   permutation(a, 0, result);
	  
	   return result;
	 
	}
	
	private void permutation(ArrayList<Integer> a, int start, 
	                       ArrayList<ArrayList<Integer>> result ) {
	      if (start >= a.size()) {
	          result.add(new ArrayList<>(a));
	      }                     
	      for (int i = start; i < a.size(); ++i) {
	        swap(a, start, i);
	        permutation(a, start+1, result);
	        swap(a, start, i);
	      }
    }
	private void swap(ArrayList<Integer>a, int i, int j) {
	    int temp = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, temp);
	}
}
