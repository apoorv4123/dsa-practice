package L29_DP;

public class WineProblem {

	public static void main(String[] args) {

//		int[] arr = { 2, 3, 5, 1, 4 };

		int[] arr = new int[1000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

//		System.out.println(WPRecursion(arr, 0, arr.length - 1, 1));
//		System.out.println(WPRecursion(arr, 0, arr.length - 1));

		System.out.println(WPTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));

		System.out.println(WPBU(arr));

	}

	public static int WPRecursion(int[] arr, int si, int ei, int yr) {

		if (si == ei) {
			return arr[si] * yr;
		}

		int left = WPRecursion(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int right = WPRecursion(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		return Math.max(left, right);

	}

	public static int WPRecursion(int[] arr, int si, int ei) {

		int yr = arr.length - (ei - si + 1) + 1;

		if (si == ei) {
			return arr[si] * yr;
		}

		int left = WPRecursion(arr, si + 1, ei) + arr[si] * yr;
		int right = WPRecursion(arr, si, ei - 1) + arr[ei] * yr;

		return Math.max(left, right);

	}

	public static int WPTD(int[] arr, int si, int ei, int[][] storage) {

		int yr = arr.length - (ei - si + 1) + 1;

		if (si == ei) {
			return arr[si] * yr;
		}

		if (storage[si][ei] != 0) { // re-use
			return storage[si][ei];
		}

		int left = WPTD(arr, si + 1, ei, storage) + arr[si] * yr; // profit obtained on selling left-most wine
		int right = WPTD(arr, si, ei - 1, storage) + arr[ei] * yr; // profit obtained on selling right-most wine

		int ans = Math.max(left, right);

		storage[si][ei] = ans; // store

		return ans;

	}

	public static int WPBU(int[] arr) {

		int n = arr.length;

		int[][] storage = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int yr = arr.length - (ei - si + 1) + 1;

				if (si == ei) {
					storage[si][ei] = arr[si] * yr;
				} else {
					int one = storage[si + 1][ei] + arr[si] * yr; // profit obtaineD on selling left-most
																	// wine
					int two = storage[si][ei - 1] + arr[ei] * yr; // profit obtaineD on selling right-most
																	// wine
					int ans = Math.max(one, two);
					storage[si][ei] = ans; // store
				}
			}

		}
		return storage[0][n - 1];
	}

}