//Reverse bits of an 32 bit unsigned integer

public class Solution {
	public long reverse(long a) {
	   
	  
	    long numBits = 32L;
	    long reverseNum = 0L;
	    for (long i = 0L; i < numBits; ++i) {
	         long num = a & (1L << i);
	         if (num != 0L) {
	             reverseNum |= (1L << (numBits-1 -i));
	         }
	    }
	    return reverseNum;
	}
}
