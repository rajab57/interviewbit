import java.util.*;
public class ReverseString {
	public static void main(String[] args) {
	String result = reverseWords("jab  ");
	System.out.println(result);
	}
	public static String reverseWords(String a) {
	    StringBuffer reversedString = new StringBuffer();
	    if (a == null || a.length() == 0) return a;
	    final String b = a.trim();
	    if (a == null || a.length() == 0) return b;
	    int start = b.length(); int end = b.length();
	    for ( int i = b.length()-1; i >= 0; --i) {
	        if (b.charAt(i) == ' ') {
	            reversedString.append(b.substring(start, end));
	            reversedString.append(' ');
	            // iterate rest of spaces
	            do {
	                end = i;
	                start = i;
	            } while (b.charAt(--i) == ' ' && i >= 0);
		    ++i;
	        } else {
	            --start;
	        }
	    }
	    reversedString.append(b.substring(start,end));
	    return reversedString.toString();
	}
}

