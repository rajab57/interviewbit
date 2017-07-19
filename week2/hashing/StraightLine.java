public class StraightLine {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	    HashMap<Double, Integer> result = new HashMap<>();
	    if (a == null || b == null ) return 0;
	    int n = a.size();
	    if (b.size() < n) n = b.size();
	    int maxCount = 0;
	    for (int i = 0; i < n; ++i ) {
	        int duplicate = 1;
	        int vertical = 0;
	        for ( int j = i+1; j < n;++j) {
	            int x1 = a.get(i);
	            int y1 = b.get(i);
	            int x2 = a.get(j);
	            int y2 = b.get(j);
	            if(x1 == x2){ // division by zero
                    if(y1 == y2){ // overlapping points
                        duplicate++;
                    }else{
                        vertical++;
                    }
                } else {
	                double slope = y1 == y2 ? 0 :(1.0 *(y2-y1)/(x2-x1));
	                //System.out.print("\n" + x1 + ":" + y1 + ", " + x2 + ":" + y2 + ":::" + slope);
	                if(result.get(slope) != null){
                        result.put(slope, result.get(slope) + 1);
                    }else{
                        result.put(slope, 1);
                    }
                }
	        }
	        for(Integer count: result.values()){
            if(count+duplicate > maxCount){
                maxCount = count+duplicate;
            }
        }
 
        maxCount = Math.max(vertical + duplicate, maxCount);
        result.clear();
        }
	    return maxCount;
	
	}
}

