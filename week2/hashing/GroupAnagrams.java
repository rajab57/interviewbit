public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    if ( a == null || a.isEmpty()) return result;
	    HashMap<String, ArrayList<Integer>> indexMap = new HashMap<>();
	    for (int i = 0; i < a.size(); ++i) {
	        String word = a.get(i);
	        String sortedWord = sortString(word);
	        if (indexMap.containsKey(sortedWord)) {
	            ArrayList<Integer> indices = indexMap.get(sortedWord);
	            indices.add(i+1);
	        } else {
	            ArrayList<Integer> indices = new ArrayList<>();
	            indices.add(i+1);
	            indexMap.put(sortedWord, indices);
	        }
	    }
	    for (Map.Entry<String, ArrayList<Integer>> entry : indexMap.entrySet()) {
	        ArrayList<Integer> indices = entry.getValue();
	        result.add(indices);
	    }
	    return result;
	    
	}
	
	
	public String sortString(String input) {
	    char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        return sortedString;
	}
}
