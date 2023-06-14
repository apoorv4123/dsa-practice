package L29_DP;

public class LCS {

	public static void main(String[] args) {

		String s1 = "abcdrhgipsljvngjrujskmchfujahhqnanxbcbvmsguizmamvnbporuyej";
		String s2 = "acdfgfjvpnfnhicmjqnazncnvmoijjvnpoqmmxnzbbvjsow";
//		s1 = "abcd";
//		s2 = "agcfd";
//		System.out.println(LCSRecursion(s1, s2));
//		System.out.println(LCSRecursionVIdx(s1, s2, 0, 0));
		System.out.println(LCRTD(s1, s2, 0, 0, new int[s1.length()][s2.length()]));
		System.out.println(LCSBU(s1, s2));
	}

	public static int LCSRecursion(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCSRecursion(ros1, ros2) + 1;
		} else {
			int one = LCSRecursion(s1, ros2);
			int two = LCSRecursion(ros1, s2);

			ans = Math.max(one, two);
		}
		return ans;
	}

	public static int LCSRecursionVIdx(String s1, String s2, int vidx1, int vidx2) {

		if (vidx1 == s1.length() || vidx2 == s2.length()) {
			return 0;
		}

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCSRecursionVIdx(s1, s2, vidx1 + 1, vidx2 + 1) + 1;
		} else {
			int one = LCSRecursionVIdx(s1, s2, vidx1, vidx2 + 1);
			int two = LCSRecursionVIdx(s1, s2, vidx1 + 1, vidx2);

			ans = Math.max(one, two);
		}
		return ans;
	}

	public static int LCRTD(String s1, String s2, int vidx1, int vidx2, int[][] storage) {

		if (vidx1 == s1.length() || vidx2 == s2.length()) {
			return 0;
		}

		if (storage[vidx1][vidx2] != 0) {
			return storage[vidx1][vidx2];
		}

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCRTD(s1, s2, vidx1 + 1, vidx2 + 1, storage) + 1;
		} else {
			int one = LCRTD(s1, s2, vidx1, vidx2 + 1, storage);
			int two = LCRTD(s1, s2, vidx1 + 1, vidx2, storage);

			ans = Math.max(one, two);
		}

		storage[vidx1][vidx2] = ans;

		return ans;

	}

	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = strg.length - 2; row >= 0; row--) {

			for (int col = strg[0].length - 2; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					strg[row][col] = Math.max(strg[row][col + 1], strg[row + 1][col]);
				}
			}
		}
		return strg[0][0];
	}

}
