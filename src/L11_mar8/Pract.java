package L11_mar8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Pract {

	public static void main(String[] args) {

//		Scanner s = new Scanner(System.in);
//		String str = s.next();
//		char[] str1 = str.toCharArray();
//		Arrays.sort(str1);
//		String st = String.copyValueOf(str1);
//		dictionaryLarger(st, str, "");
//		System.out.println();
//		dictionarySmaller(st, str, "");

//		int ans = printss(str, "");
//		System.out.println();
//		System.out.println(ans);

//		Scanner scn = new Scanner(System.in);
//		int col = scn.nextInt();
//		int row = scn.nextInt();
//		int ans = printMazePath(1, 1, row, col, "");
//		System.out.println();
//		System.out.print(ans);
//		printPermutations("abc", "");
//		System.out.println(countPermutations("abc"));
//		printSS("abc", "");
//		System.out.println(countSS("abc", ""));
//		printKPC("145", "");
//		System.out.println(countKPC("145", ""));
//		printMazePath(0, 0, 2, 2, "");
//		System.out.println(countmazePath(0, 0, 2, 2));
//		printBoardPath(0, 5, "");
//		System.out.println(countBoardPath(0, 10));
//		validParenthesis(3, 0, 0, "");
//		lexicoPrinting(1000, 0);
//		System.out.println(mul(0, 3, 5));
//		codesOfTheString(1123, "");
//		System.out.println(codesOfString("1020"));
//		int[] nums = { 1, 2, 3 };
//		System.out.println(subarraySum(nums, 3));
		
	}

	public static void isPalindrome() {

	}

	public static int subarraySum(int[] nums, int k) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int sum = 0;
				for (int k1 = i; k1 <= j; k1++) {
					sum += nums[k1];
				}
				if (sum == k) {
					n++;
				}
			}
		}
		return n;
	}

	public static void printPermutations(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int idx = 0; idx < ques.length(); idx++) {
			char ch = ques.charAt(idx);
			String roq = ques.substring(0, idx) + ques.substring(idx + 1);
			printPermutations(roq, ans + ch);
		}

	}

	public static int countPermutations(String ques) {

		if (ques.length() == 0) {
			return 1;
		}
		int count = 0;
		for (int idx = 0; idx < ques.length(); idx++) {
			String roq = ques.substring(0, idx) + ques.substring(idx + 1);
			count += countPermutations(roq);
		}
		return count;

	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		printSS(roq, ans);
		printSS(roq, ans + ch);
	}

	public static int countSS(String ques, String ans) {

		if (ques.length() == 0) {
			return 1;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		return countSS(roq, ans) + countSS(roq, ans + ch);
	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static void printKPC(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String code = getCode(ch);
		String roq = ques.substring(1);
		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}
	}

	public static int countKPC(String ques, String ans) {
		if (ques.length() == 0) {
			return 1;
		}
		char ch = ques.charAt(0);
		String code = getCode(ch);
		String roq = ques.substring(1);
		int count = 0;
		for (int i = 0; i < code.length(); i++) {
			count += countKPC(roq, ans + code.charAt(i));
		}
		return count;
	}

	public static int printMazePath(int cc, int cr, int ec, int er, String ans) {

		if (cc == ec && cr == er) {
			System.out.print(ans + " ");
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}
		int count = 0;
		count += printMazePath(cc, cr + 1, ec, er, ans + "V");
		count += printMazePath(cc + 1, cr, ec, er, ans + "H");
		if (cr == cc)
			count += printMazePath(cc + 1, cr + 1, ec, er, ans + "D");
		return count;
	}

	public static int countmazePath(int cc, int cr, int ec, int er) {

		if (cc == ec && cr == er) {
			return 1;
		}
		if (cc > ec || cr > er) {
			return 0;
		}
		return countmazePath(cc + 1, cr, ec, er) + countmazePath(cc, cr + 1, ec, er)
				+ countmazePath(cc + 1, cr + 1, ec, er);
	}

	public static void printBoardPath(int curr, int target, String ans) {
		if (curr == target) {
			System.out.println(ans);
			return;
		}
		if (curr > target) {
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			printBoardPath(curr + dice, target, ans + dice);
		}
	}

	public static int countBoardPath(int curr, int target) {
		if (curr == target) {
			return 1;
		}
		if (curr > target) {
			return 0;
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += countBoardPath(curr + dice, target);
		}
		return count;
	}

	public static void validParenthesis(int n, int count_open, int count_close, String ans) {
		if (count_close == n && count_open == n) {
			System.out.println(ans);
			return;
		}
		if (count_open > n || count_close > count_open) {
			return;
		}
		validParenthesis(n, count_open + 1, count_close, ans + '(');
		validParenthesis(n, count_open, count_close + 1, ans + ')');
	}

	public static void lexicoPrinting(int max, int curr) {
		if (curr > max) {
			return;
		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0) {
			i = 1;
		}
		while (i <= 9) {
			lexicoPrinting(max, curr * 10 + i);
			i++;
		}
	}

	public static void dictionaryLarger(String ques, String str, String ans) {

		if (ques.length() == 0) {
			if (str.compareTo(ans) < 0) {
				System.out.println(ans);
			}
			return;
		}
		for (int idx = 0; idx < ques.length(); idx++) {
			char ch = ques.charAt(idx);
			String roq = ques.substring(0, idx) + ques.substring(idx + 1);
			dictionaryLarger(roq, str, ans + ch);
		}
	}

	public static void dictionarySmaller(String ques, String str, String ans) {

		if (ques.length() == 0 && str.length() == ans.length()) {
			if (str.compareTo(ans) > 0) {
				System.out.println(ans);
			}
			return;
		}
		for (int idx = 0; idx < ques.length(); idx++) {
			char ch = ques.charAt(idx);
			String roq = ques.substring(0, idx) + ques.substring(idx + 1);
			dictionarySmaller(roq, str, ans + ch);
		}
	}

	public static ArrayList<String> codesOfString(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		String ch = str.substring(0, 1);
		String roq = str.substring(1);
		ArrayList<String> mr = new ArrayList<>();
		if (Integer.parseInt(ch, 10) > 0) {
			char ch1 = (char) (Integer.parseInt(ch, 10) + 'a' - 1);
			ArrayList<String> rr = codesOfString(roq);
			for (String val : rr) {
				mr.add(ch1 + val);
			}
		}
		if (str.length() >= 2) {
			String ch2 = str.substring(0, 2);
			String roq2 = str.substring(2);
			int n = Integer.parseInt(ch2, 10);
			if (n <= 26 && n >= 0) {
				char ch3 = (char) (Integer.parseInt(ch2, 10) + 'a' - 1);
				ArrayList<String> rr2 = codesOfString(roq2);
				for (String val : rr2) {
					mr.add(ch3 + val);
				}
			}
		}
		return mr;
	}
}