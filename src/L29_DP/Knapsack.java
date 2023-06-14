package L29_DP;

public class Knapsack {

	public static void main(String[] args) {

//		int[] wt = new int[1000];
//		int[] price = new int[1000];
//		for (int i = 0; i < wt.length; i++) {
//			wt[i] = i + 1;
//			price[i] = i + 1;
//		}
//		int cap = 70;

		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };

		int cap = 7;
//		int[][] strg = new int[wt.length][cap + 1];
		System.out.println(knapsackRecursion(wt, price, 0, cap));
//		System.out.println(knapsackTD(wt, price, 0, cap, strg));

//		System.out.println(knapsackBU(wt, price, cap));

	}

	private static int knapsackRecursion(int[] wt, int[] price, int vidx, int cap) {

		if (vidx == wt.length || cap == 0) {
			return 0;
		}

		// exclude
		int e = knapsackRecursion(wt, price, vidx + 1, cap);

		// include
		int i = 0;

		if (cap >= wt[vidx])
			i = knapsackRecursion(wt, price, vidx + 1, cap - wt[vidx]) + price[vidx];

		int ans = Math.max(e, i);

		return ans;
	}

	private static int knapsackTD(int[] wt, int[] price, int vidx, int cap, int[][] storage) {

		if (vidx == wt.length || cap == 0) {
			return 0;
		}

		if (storage[vidx][cap] != 0) {
			return storage[vidx][cap];
		}

		// exclude
		int e = knapsackTD(wt, price, vidx + 1, cap, storage);

		// include
		int i = 0;

		if (cap >= wt[vidx])
			i = knapsackTD(wt, price, vidx + 1, cap - wt[vidx], storage) + price[vidx];

		int ans = Math.max(e, i);

		storage[vidx][cap] = ans;

		return ans;
	}

	public static int knapsackBU(int[] wt, int[] price, int cap) {

		int n = wt.length;

		int[][] storage = new int[n + 1][cap + 1];

		for (int row = n - 1; row >= 0; row--) {

			for (int col = 1; col <= cap; col++) {

				// use the same logic of top-down
				// exclude
				int e = storage[row + 1][col];

				// include
				int i = 0;

				if (col >= wt[row])
					i = storage[row + 1][col - wt[row]] + price[row];

				int ans = Math.max(e, i);

				storage[row][col] = ans;

			}
		}

//		for (int i = 0; i < storage.length; i++) {
//			for (int j = 0; j < storage[0].length; j++) {
//				System.out.print(storage[i][j] + "\t");
//			}
//			System.out.println();
//		}

		return storage[0][cap];
	}

}
