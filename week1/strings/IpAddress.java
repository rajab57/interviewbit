import java.util.*;
public class IpAddress {
	public static void main(String []args){
		restoreIpAddresses("0100100");
		restoreIpAddresses("25525511135");
	}
	public static ArrayList<String> restoreIpAddresses(String a) {
	    ArrayList<String> res = new ArrayList<String>();
	    if (a == null || a.length() < 4 || a.length() > 12) return res;
	  
	    dfs(a, "", res, 0 );
	    return res;
	}
	
	public static void dfs(String s, String tmp, ArrayList<String> res, int count){  
	    if (count == 3 && isValid(s)) {
	        res.add(tmp +s);
	        return;
	    }
	    for ( int i = 1; i < 4 && i < s.length(); ++i) {
	        String substr = s.substring(0,i);
	        if (isValid(substr)) {
	            dfs(s.substring(i), tmp + substr +".", res, count+1);
	        }
	    }
	}
	
	 public static boolean isValid(String s){  
        	if (s.charAt(0)=='0') return s.equals("0");  
        	int num = Integer.parseInt(s);  
        	return num<=255 && num>0;  
    	}  
}

