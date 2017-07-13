import java.util.*;
public class NobleNumber {
   public static void main(String[] args) {
   	List<Integer> list = Arrays.asList(-4, -2, 0, -1, -6);
   	int result = solve(new ArrayList(list));
	System.out.println(result);
   }
    public static int solve(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) {
            return -1;
        }
        Collections.sort(A);
        int size = A.size();
	int lastSeen = A.get(0);
        for (int i = 0; i < size; ++i) {
            int num = A.get(i);
	    if (lastSeen == num) continue;
            int numGreater = size -i ;
	    System.out.println(lastSeen +"::" + numGreater);
            if ( lastSeen == numGreater) {
                System.out.println(num);
                return 1;
	    }
            lastSeen = num;
        }
	if (lastSeen == 0) return 1;
        return -1;
    }
}
