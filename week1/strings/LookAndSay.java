import java.util.*;
public class LookAndSay {
	public static void main(String[] args) {
		String s = countAndSay(4);
	}

	public static String countAndSay(int a) {
	    String s = "1";
	    for ( int i = 1; i < a; i++) {
	       s = CountAndSayHelper(s);
	    }
	    return s;
	}
	
	public static String CountAndSayHelper(String s){
	    StringBuffer result = new StringBuffer();
	    int count = 1; char lastSeen = s.charAt(0);
	    for ( int i = 1; i < s.length(); ++i) {
	        if (lastSeen != s.charAt(i)) {
	            result.append(count);
	            result.append(lastSeen);
	            lastSeen = s.charAt(i);
	            count = 1;
	        } else {
			++count;
		}
	    }
	    result.append(count);
	    result.append(lastSeen);
	    return result.toString();
	}
}
