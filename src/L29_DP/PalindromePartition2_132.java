package L29_DP;

public class PalindromePartition2_132 {

	public static void main(String[] args) {

		System.out.println(PP("a", ""));
	}

	public static int PP(String ques, String ans) {

		if (ques.length() == 0) {
//			System.out.println(ans);
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= ques.length(); i++) {
			String part = ques.substring(0, i);
			int res = 0;
			if (isPalindrome(part, 0, part.length() - 1)) {
				res = PP(ques.substring(i), ans + part + " ") + 1;
			}
			if (res < min) {
				min = res;
			}
		}
		min++;
//		System.out.println("------" + min);
		return min;

	}

	public static boolean isPalindrome(String str, int si, int ei) {
		if (si >= ei) {
			return true;
		}
		if (str.charAt(si) == str.charAt(ei)) {
			return isPalindrome(str, si + 1, ei - 1);
		} else {
			return false;
		}
	}

}