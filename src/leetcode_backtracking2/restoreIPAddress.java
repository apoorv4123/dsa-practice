package leetcode_backtracking2;

import java.util.ArrayList;
import java.util.List;

public class restoreIPAddress {

	// https://leetcode.com/problems/restore-ip-addresses/

	public static void main(String[] args) {

		String s = "25525511135";
		System.out.println(restoreIPaddress(s));

	}

	public static List<String> restoreIPaddress(String s) {

		List<String> list = new ArrayList<String>();

		if (s.length() <= 12) // if we use this here, we won't need to use negative base case for nod
			restoreIPaddress(s, "", list, 0);

		return list;

	}

	public static void restoreIPaddress(String s, String ans, List<String> temp, int nod) {

		if (s.length() == 0) {
			if (nod == 4)
				temp.add(ans.substring(0, ans.length() - 1));
			return;
		}

//		if (nod > 4) {
//			return;
//		}

		if (s.length() > (4 - nod) * 3) {
			return;
		}

		for (int i = 1; i <= s.length() && i <= 3; i++) {
//			if (i <= s.length()) {
			String part = s.substring(0, i);
			String roq = s.substring(i);

			int num = Integer.parseInt(part);

			if (num >= 0 && num <= 255 && noleadingZeros(part))
				restoreIPaddress(roq, ans + part + ".", temp, nod + 1);
		}
//		}

	}

	public static boolean noleadingZeros(String s) {
		if (s.length() <= 1) {
			return true;
		}
		return s.charAt(0) != '0';
	}

}
