package L10_mar7;

import java.util.ArrayList;

public class ALandRPractice {

	public static void main(String[] args) {
//		System.out.println(getSS("abc"));
//		System.out.println(getSSASCII("bc"));
//		System.out.println(getKPC("12"));
//		System.out.println(getCoinToss(3));
//		System.out.println(getPermutations("abc"));
//		System.out.println(getBoardPath(0, 7));

//		System.out.println(getStairPaths(3));

//		String str = "abc";
//		System.out.println(str.substring(2,2));

		lexicographicalCounting(0, 15);
	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		ArrayList<String> rr = getSS(str.substring(1));
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
		}
		return mr;
	}

	public static ArrayList<String> getSSASCII(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		ArrayList<String> rr = getSSASCII(str.substring(1));
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
			mr.add((int) ch + val);
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

	public static ArrayList<String> getKPC(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		String code = getCode(str.charAt(0));
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getKPC(str.substring(1));
		for (String val : rr) {
			for (int i = 0; i < code.length(); i++) {
				mr.add(code.charAt(i) + val);
			}
		}
		return mr;
	}

	public static ArrayList<String> getCoinToss(int n) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		ArrayList<String> rr = getCoinToss(n - 1);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add('H' + val);
			mr.add('T' + val);
		}
		return mr;
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getPermutations(str.substring(1));
		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}
		return mr;
	}

	public static ArrayList<String> getBoardPath(int cn, int en) {
		if (cn > en) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}
		if (cn == en) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			ArrayList<String> rr = getBoardPath(cn + i, en);
			for (String val : rr) {
				mr.add(i + val);
			}
		}
		return mr;
	}

	public static ArrayList<String> getStairPaths(int n) {
		if (n < 0) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> nm1 = getStairPaths(n - 1);
		for (String path : nm1) {
			mr.add("1" + path);
		}

		ArrayList<String> nm2 = getStairPaths(n - 2);
		for (String path : nm2) {
			mr.add("2" + path);
		}

		ArrayList<String> nm3 = getStairPaths(n - 3);
		for (String path : nm3) {
			mr.add("3" + path);
		}

		return mr;
	}

	public static void printSS(String ques, String ans) {

	}

	// print 1 to max in lexicographical order
	public static void lexicographicalCounting(int curr, int max) {
		if (curr > max) {
			return;
		}
		if (curr != 0) {
			System.out.println(curr);
		}
		for (int i = 0; i <= 9; i++) {
			if (curr + i == curr) {
				continue;
			}
			lexicographicalCounting(curr * 10 + i, max);
		}
	}

}
