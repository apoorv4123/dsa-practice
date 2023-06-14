package leetcode_backtracking2;

import java.util.ArrayList;
import java.util.List;

public class splitArrayIntoFibonacciSequence {

	// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

	public static void main(String[] args) {
		System.out.println(splitIntoFibonacci("1101111"));
	}

	public static List<Integer> splitIntoFibonacci(String s) {

		List<Integer> main = new ArrayList<>();
		splitIntoFibonacci(s, main, new ArrayList<>());
		return main;

	}

	public static void splitIntoFibonacci(String s, List<Integer> main, List<Integer> temp) {

		if (s.length() == 0) {
			if (temp.size() >= 3 && main.size() == 0)// to ensure only one Ans is returned
				main.addAll(temp);// addAll se temp ka saara content main m add ho jaiga
			return;
		}

		for (int i = 1; i <= s.length() && i <= 10; i++) {

			String part = s.substring(0, i);
			String roq = s.substring(i);

			if (partInRange(part)) {

				int num = Integer.parseInt(part);

				if (isFibonacci(temp, num) && noLeadingZeros(part)) {
					temp.add(num);
					splitIntoFibonacci(roq, main, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	private static boolean partInRange(String str) {

		if (str.length() >= 11) {
			return false;
		}

		return Long.parseLong(str) <= (Math.pow(2, 31) - 1);
		// if by chance the number str is out of range of Integer and we use
		// Integer.parseInt above then it'll give an error so we use Long.parseLong().

	}

	private static boolean noLeadingZeros(String str) {
		if (str.length() <= 1) {
			return true;
		}
		return str.charAt(0) != '0';
	}

	private static boolean isFibonacci(List<Integer> temp, int num) {
		// this code is valid only when there are at least 2 elements in temp
		if (temp.size() < 2) {
			return true;
		}
		int lastnum = temp.get(temp.size() - 1);
		int seclastnum = temp.get(temp.size() - 2);

		return num == lastnum + seclastnum;
	}

}