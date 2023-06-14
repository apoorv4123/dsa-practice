package L10_mar7;

import java.util.ArrayList;

public class ArrayListandRecursion {

	public static void main(String[] args) {

		System.out.println(getSS("abc"));
		System.out.println(getSSAscii("bc"));

		// In this question we will toss a coin a number of times and will
		// return the possible arrangements of outcome in an array-list
		System.out.println(coinToss(3));

		System.out.println(getPermutation("abcd"));

		System.out.println(getBoardPath(0, 10));

		System.out.println(getMazePath(0, 0, 2, 2));

		// keypad combinations
		System.out.println(getKPC("145"));

	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getSS(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
		}
		return mr;
	}

	public static ArrayList<String> getSSAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getSSAscii(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
			mr.add((int) ch + val);
		}
		return mr;
	}

	public static ArrayList<String> coinToss(int n) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> rr = coinToss(n - 1);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add('H' + val);
			mr.add('V' + val);
		}
		return mr;
	}

	public static ArrayList<String> getPermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getPermutation(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}
		return mr;
	}

	public static ArrayList<String> getBoardPath(int cn, int en) {
		if (cn == en) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}
		if (cn > en) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPath(cn + dice, en);
			for (String val : rr) {
				mr.add(dice + val);
			}
		}
		return mr;
	}

	public static ArrayList<String> getMazePath(int cc, int cr, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrh = getMazePath(cc + 1, cr, er, ec);
		for (String val : rrh) {
			mr.add('H' + val);
		}
		ArrayList<String> rrv = getMazePath(cc, cr + 1, er, ec);
		for (String val : rrv) {
			mr.add('V' + val);
		}
		ArrayList<String> rrd = getMazePath(cc + 1, cr + 1, er, ec);
		for (String val : rrd) {
			mr.add('D' + val);
		}
		return mr;
	}

	public static ArrayList<String> getKPC(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getKPC(ros);
		ArrayList<String> mr = new ArrayList<>();
		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			for (String val : rr) {
				mr.add(code.charAt(i) + val);
			}
		}
		return mr;
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

}
