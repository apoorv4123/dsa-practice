package leetcode_backtracking2;

import java.util.ArrayList;
import java.util.List;

public class additiveNumber {

	// https://leetcode.com/problems/additive-number/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAdditiveNumber("112358"));

	}

	public static boolean isAdditiveNumber(String num) {

//		List<Integer> main = new ArrayList<Integer>();
		return isAdditiveNumber(num, new ArrayList<>());
//		System.out.println(main);

	}

	public static boolean isAdditiveNumber(String num, List<Integer> temp) {

		if (num.length() == 0) {
			if (temp.size() > 2)
				return true;
			return false;
		}

		boolean ans = false;

		for (int i = 1; i <= num.length(); i++) {
			String part = num.substring(0, i);
			String roq = num.substring(i);

			if (inRange(part)) {
				int n = Integer.parseInt(part);

				if (isTrueTillNow(temp, n) && noLeadingZeroes(part)) {
					temp.add(n);
					ans = ans || isAdditiveNumber(roq, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}
		return ans;
	}

	private static boolean inRange(String part) {

		if (part.length() > 10)
			return false;

		return Long.parseLong(part) <= (Math.pow(2, 31) - 1);
	}

	private static boolean noLeadingZeroes(String part) {

		if (part.length() <= 1)
			return true;

		return part.charAt(0) != '0';
	}

	private static boolean isTrueTillNow(List<Integer> temp, int n) {

		if (temp.size() < 2) {
			return true;
		}
		int lastnum = temp.get(temp.size() - 1);
		int seclastnum = temp.get(temp.size() - 2);

		return n == lastnum + seclastnum;
	}

}