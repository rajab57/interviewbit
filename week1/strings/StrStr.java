public class StrStr {
	public int strStr(final String haystack, final String needle) {
	    if ( haystack == null || needle == null || haystack.length() == 0 || needle.length() == 0) return -1;
	    
	    for ( int i = 0; i < haystack.length(); ++i) {
	       if (needle.length() > haystack.length() - i) return -1;
	       int index = i;
	       for (int j = 0; j < needle.length(); ++j) {
	           if (haystack.charAt(index) == needle.charAt(j)) {
	               ++index;
	               if (j == needle.length()-1)  return i;
	           } else {
	               break;
	           }
	       }
	    }
	    return -1;
	}
}

