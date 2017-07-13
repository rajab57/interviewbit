import java.util.*;
public class RomanToInt {
	public static void main(String[] args) {
		System.out.println(intToString(-145));
		System.out.println(stringToInt("-145"));
	}

	public static String intToString(int num) {
		boolean isNegative = false;
		StringBuilder s = new StringBuilder();
		if ( num < 0 ) isNegative = true;
		while ( num != 0 ) {
			s.append((char)('0' + Math.abs(num%10)));
			num = num / 10;
		}
		if (isNegative) s.append('-');
		s.reverse();
		return s.toString();
	}


	public static int stringToInt(String s) {
		int result = 0;
		int i = 0;
		boolean isNegative = false;
		if (s.charAt(i) == '-')  {
			isNegative = true;
			++i;
		}
		for (; i < s.length(); ++i) {
			result = result *10 + (s.charAt(i) - '0');
		}
		if ( isNegative) result = -result;
		return result;
	}
}

