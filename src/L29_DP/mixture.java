package L29_DP;

import java.util.Arrays;

public class mixture {

	public static void main(String[] args) {

		int[] colors = { 40, 60, 20, 50 };
		System.out.println(mixtureRecursion(colors, 0, colors.length - 1));

		int[][] storage = new int[colors.length][colors.length];
		for (int i = 0; i < storage.length; i++) {
			Arrays.fill(storage[i], -1);
		}
		System.out.println(mixtureTD(colors, 0, colors.length - 1, storage));
	}

	public static int mixtureRecursion(int[] arr, int si, int ei) {

		if (ei == si) {
			return 0;
		}

//		if (ei - si == 1) {
//			return arr[si] * arr[ei];
//		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = mixtureRecursion(arr, si, k);
			int sp = mixtureRecursion(arr, k + 1, ei);

			int sw = colorOfMixture(arr, si, k) * colorOfMixture(arr, k + 1, ei);

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}

		return min;

	}

	public static int colorOfMixture(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}
		return sum % 100;
	}

	public static int mixtureTD(int[] arr, int si, int ei, int[][] storage) {

		if (ei == si) {
			return 0;
		}

		if (storage[si][ei] != -1) {
			return storage[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = mixtureTD(arr, si, k, storage);
			int sp = mixtureTD(arr, k + 1, ei, storage);

			int sw = colorOfMixture(arr, si, k) * colorOfMixture(arr, k + 1, ei);

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}

		storage[si][ei] = min;

		return min;

	}

}
