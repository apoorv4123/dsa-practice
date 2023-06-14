package L11_mar8;

public class RecursionPrint {

	public static void main(String[] args) {
//	    validPaenthesis(3, 0, 0, "");
//		lexicocounting(0, 1000);
//		System.out.println(isPalindrome("nitin"));
		palindromePartition("nitin", "");
//		lexprint(0, 1000);
		pp("nitin", "");
	}

	public static void pp(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= str.length(); i++) {
			String ros = str.substring(i);
			String part = str.substring(0, i);
			if (isPalindrome(part)) {
				pp(ros, ans + part + " ");
			}
		}
	}

	public static void palindromePartition(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= ques.length(); i++) {
			String part = ques.substring(0, i);
			String roq = ques.substring(i);
			if (isPalindrome(part))
				palindromePartition(roq, ans + part + " ");
		}
	}

	public static void validPaenthesis(int n, int open, int close, String ans) {

		if (open == close && open == n) {
			System.out.println(ans);
			return;
		}
		if (close > open || open > n) {
			return;
		}
		validPaenthesis(n, open + 1, close, ans + "(");
		validPaenthesis(n, open, close + 1, ans + ")");

	}

	public static void lexicocounting(int curr, int max) {
		if (curr > max) {
			return;
		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0) {
			i = 1;
		}
		while (i <= 9) {
			lexicocounting(curr * 10 + i, max);
			i++;
		}
	}

	public static void lexprint(int curr, int max) {
		if (curr > max) {
			return;
		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0) {
			i = 1;
		}
		for (; i <= 9; i++) {
			lexprint(curr * 10 + i, max);
		}
	}

	public static boolean isPalindrome(String str) {

		int i = 0;
		int len = str.length();
		while (i <= str.length() / 2) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) {
				return false;
			}
			i++;
		}
		return true;
	}
}