import java.util.*;
public class ZeroSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int max_len = 0;
        int lastPos = 0;
        for ( int i = 0; i < a.size(); ++i) {
            sum += a.get(i);
            
            if (a.get(i) == 0 && max_len == 0) {
				max_len = 1;
				lastPos = i;
            }
				
            if ( sum == 0 ) {
                max_len = i+1;
                lastPos = i;
            }
            Integer prev_i = sumMap.get(sum);
            if ( prev_i != null) {
                //System.out.print(" == i:" + i + "prev_i:" + prev_i + " max_len:" + max_len);
        
                if ((i-prev_i) > max_len) {
                    lastPos = i;
                    max_len = i-prev_i;
                }
            } else {
                sumMap.put(sum, i);
                //System.out.print(" == sum:" + sum + "i:" + i);
            }
            
        }
        //System.out.print(" last Pos : " + lastPos + " max_len " + max_len + " ");
        ArrayList<Integer> output = new ArrayList<>();
        for ( int i = lastPos-max_len+1; i <= lastPos; ++i) {
            output.add(a.get(i));
        }
        return output;
    }
}

