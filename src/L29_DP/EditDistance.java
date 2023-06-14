package L29_DP;

public class EditDistance {

	public static void main(String[] args) {
		String s1 = "sunday";
		String s2 = "saturaday";

//		System.out.println(EDRecursion(s1, s2));
//		System.out.println(EDRecursionVidx(s1, s2, 0, 0));

		int[][] storage = new int[s1.length()][s2.length()];

		for (int row = 0; row < storage.length; row++) {
			for (int col = 0; col < storage[0].length; col++) {
				storage[row][col] = -1;
			}
		}

		System.out.println(EDTD(s1, s2, 0, 0, storage));

		System.out.println(EDBU(s1, s2));
	}

	public static int EDRecursion(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {

			ans = EDRecursion(ros1, ros2);

		} else {

			int i = EDRecursion(ros1, s2); // insert
			int d = EDRecursion(s1, ros2); // Delete
			int r = EDRecursion(ros1, ros2); // replace

			ans = Math.min(i, Math.min(d, r)) + 1;
		}

		return ans;

	}

	public static int EDRecursionVidx(String s1, String s2, int vidx1, int vidx2) {

		if (vidx1 == s1.length() || vidx2 == s2.length()) {
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);
		}

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EDRecursionVidx(s1, s2, vidx1 + 1, vidx2 + 1);
		} else {

			int i = EDRecursionVidx(s1, s2, vidx1 + 1, vidx2); // insert
			int d = EDRecursionVidx(s1, s2, vidx1, vidx2 + 1); // Delete
			int r = EDRecursionVidx(s1, s2, vidx1 + 1, vidx2 + 1); // replace

			ans = Math.min(i, Math.min(d, r)) + 1;
		}

		return ans;

	}

	public static int EDTD(String s1, String s2, int vidx1, int vidx2, int[][] storage) {

		if (vidx1 == s1.length() || vidx2 == s2.length()) {
			return Math.max(s1.length() - vidx1, s2.length() - vidx2);
		}

		if (storage[vidx1][vidx2] != -1) {
			return storage[vidx1][vidx2];
		}

		char ch1 = s1.charAt(vidx1);
		char ch2 = s2.charAt(vidx2);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EDTD(s1, s2, vidx1 + 1, vidx2 + 1, storage);
		} else {

			int i = EDTD(s1, s2, vidx1 + 1, vidx2, storage); // insert
			int d = EDTD(s1, s2, vidx1, vidx2 + 1, storage); // Delete
			int r = EDTD(s1, s2, vidx1 + 1, vidx2 + 1, storage); // replace

			ans = Math.min(i, Math.min(d, r)) + 1;
		}

		storage[vidx1][vidx2] = ans;

		return ans;

	}

	public static int EDBU(String s1, String s2) {

		// create a 2d array
		int[][] storage = new int[s1.length() + 1][s2.length() + 1];

		// filling : bottom to top & right to left
		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				// base case : deletion ops : bottom most row
				if (row == s1.length()) {
					storage[row][col] = s2.length() - col;
				}
				// base case : insertion ops : right most column
				else if (col == s2.length()) {
					storage[row][col] = s1.length() - row;
				}
				// any intermediate cell
				else {
					if (s1.charAt(row) == s2.charAt(col)) {
						storage[row][col] = storage[row + 1][col + 1];
					} else {
						int o1 = storage[row + 1][col];
						int o2 = storage[row][col + 1];
						int o3 = storage[row + 1][col + 1];

						storage[row][col] = Math.min(o1, Math.min(o2, o3)) + 1;
					}
				}
			}
		}
		return storage[0][0];
	}

}