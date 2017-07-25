public class Solution {
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
	    
	   HashMap<String, Integer> wordCount = new HashMap<>();
	   ArrayList<Integer> result = new ArrayList<>();
	   for (int i = 0; i < b.size(); ++i) {
	       String word = b.get(i);
	       if (wordCount.containsKey(word)) {
	           wordCount.put(word, wordCount.get(word)+1);
	       } else {
	           wordCount.put(word, 1);
	       }
	   }
	   int len = b.get(0).length();
	   for (int i = 0; i < len; ++i) {
	       int start = i;
	       int count = 0;
	       HashMap<String, Integer> presenceMap = new HashMap<>();
	       for (int j = i; j <= a.length()-len; j=j+len) {
	           String sub = a.substring(j, j+len);
	           if(wordCount.containsKey(sub)){
                    if(presenceMap.containsKey(sub)){
                        presenceMap.put(sub, presenceMap.get(sub)+1);
                    }else{
                        presenceMap.put(sub, 1);
                    }
                    ++count;
                    while(presenceMap.get(sub)>wordCount.get(sub)){
                        String left = a.substring(start, start+len);
                        presenceMap.put(left, presenceMap.get(left)-1);
 
                        count--;
                        start = start + len;
                    }
                    if (count == b.size()) {
                        result.add(start);
                        //shift right remove last word from map          
                        String left = a.substring(start, start+len);
                        presenceMap.put(left, presenceMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                } else {
                    presenceMap.clear();
                    start = j+len;
                    count = 0;
                }
	       }
	   }
	   
	   return result;
	}
}
