public class LastWord {
	public int lengthOfLastWord(final String a) {
	    if (a == null || a.length() == 0) return 0;
	    String b = a.trim();
	    int start = 0; int count = 0;
	    for (int i = 0; i < b.length(); ++i ) {
	        if (b.charAt(i) == ' ') {
	            start = start +1;
	            count = 0;
	        } else {
	            ++count;
	        }
	    }
	    return count;
	}
}

