package L29_DP;

public class MatrixChainMultiplication {

	public static void main(String[] args) {

		int[] arr = { 4, 2, 3, 5, 1 };

//		int[] arr = new int[1000];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = i + 1;
//		}

		System.out.println(MCMRecursion(arr, 0, arr.length - 1));

//		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
//		System.out.println(MCMBU(arr));
	}

	public static int MCMRecursion(int[] arr, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		// k : splits
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMRecursion(arr, si, k); // first problem
			int sp = MCMRecursion(arr, k, ei); // second problem

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}

		return min;

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] storage) {

		if (si + 1 == ei) {
			return 0;
		}

		if (storage[si][ei] != 0) {
			return storage[si][ei];
		}

		int min = Integer.MAX_VALUE;

		// k : splits
		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTD(arr, si, k, storage); // first problem
			int sp = MCMTD(arr, k, ei, storage); // second problem

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}
		storage[si][ei] = min;
		return min;
	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;

		int[][] storage = new int[n][n];

		for (int slide = 1; slide <= arr.length - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				// logic which was used in top-down
				if (si + 1 == ei) {
					storage[si][ei] = 0;
				} else {
					int min = Integer.MAX_VALUE;

					// k : splits
					for (int k = si + 1; k <= ei - 1; k++) {

						int fp = storage[si][k]; // first problem
						int sp = storage[k][ei]; // second problem

						int sw = arr[si] * arr[k] * arr[ei];

						int total = fp + sp + sw;

						if (total < min) {
							min = total;
						}
					}
					storage[si][ei] = min;
				}
			}
		}

		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[0].length; j++) {
				System.out.print(storage[i][j] + "\t");
			}
			System.out.println();
		}

		return storage[0][arr.length - 1];
	}

}