package hackerBlocks_Recursion;

import java.util.Scanner;

public class MaxIntegerWithAtMostKSwaps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = 4; // at most k swaps

		char[] arr = str.toCharArray();

		System.out.println(kSwaps(arr, k, 0));

		scn.close();
	}

	public static int kSwaps(char[] arr, int k, int idx) {

		if (k == 0 || idx == arr.length) {
			String str = new String(arr);
			return Integer.parseInt(str);
		}

		int ans = 0;

		char max = max(arr, idx);

		if (arr[idx] == max) {
			ans = kSwaps(arr, k, idx + 1);
		} else {
			for (int i = idx + 1; i < arr.length; i++) {

				if (arr[i] == max) {
					swap(arr, idx, i);

					int rr = kSwaps(arr, k - 1, idx + 1);

					if (rr > ans) {
						ans = rr;
					}

					swap(arr, idx, i);
				}

			}

		}
		return ans;
	}

	public static void swap(char[] arr, int idx, int i) {
		char temp = arr[idx];
		arr[idx] = arr[i];
		arr[i] = temp;
	}

	public static char max(char[] arr, int idx) {

		char max = arr[idx];
		for (int i = idx + 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;

	}

}
