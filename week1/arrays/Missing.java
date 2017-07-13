/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Repeat and Missing Number Array

*/
import java.util.*;
public class Missing {
	public static void main(String[] args) {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(3);
		a.add(1);
		a.add(2);
		a.add(5);
		a.add(3);
                ArrayList<Integer> result = repeatedNumber(a);
        }

	// DO NOT MODIFY THE LIST
	public static ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    long max = (int) a.size();
            long missing = 0;
            long duplicate = 0;
            long currentTotal = 0;
            long currentSquareSum = 0;
            ArrayList<Integer> result = new ArrayList<>();
            for ( int i = 0; i < a.size(); ++i) {
                long num = (long)a.get(i);
                currentTotal = currentTotal + (long)num;
                currentSquareSum = currentSquareSum + (long)(num * num);
            }
            long expectedTotal = (long) (max *(max+1))/2;
            long expectedSquareSum = (long)((max * (max+1)*(2*max +1))/6);
            long diff = currentTotal - expectedTotal;
            long squaredDiff = currentSquareSum - expectedSquareSum;
            missing = (long)((squaredDiff/diff)-diff)/2;
            currentTotal= currentTotal + (long) missing;
            duplicate = (long)(currentTotal - expectedTotal);
            result.add((int)duplicate);
            result.add((int)missing);
            return result;
	}
	}
}

