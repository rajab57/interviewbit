// Write a function that takes an unsigned integer and returns the number of 1 bits it has.
public class Solution {
	public int numSetBits(long a) {
	    int bits = 0;
	    int mask = 1;
	    for ( int i = 0; i < 64; ++i) {
	        if ( (a & mask) != 0) {
	            ++bits;
	        }
	        mask = mask << 1;
	    }
	    return bits;
	}
}
