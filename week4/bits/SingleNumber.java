// Given an array of integers, every element appears twice except for one. Find that single one.
public class Solution {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int result = 0;
	    for (Integer num : a) {
	        result ^= num;
	    }
	    return result;
	}
}
