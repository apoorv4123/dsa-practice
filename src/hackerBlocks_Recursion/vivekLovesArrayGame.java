package hackerBlocks_Recursion;

import java.util.Scanner;

public class vivekLovesArrayGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int test = s.nextInt();

		while (test > 0) {

			int n = s.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}

			System.out.println(maxPoints(arr, 0, arr.length - 1));

			test--;
		}

		s.close();
	}

	public static int maxPoints(int[] arr, int lo, int hi) {

		//all possible splits
		for (int split = lo; split <= hi - 1; split++) {

			// sum of left part
			int sum1 = sumArr(arr, lo, split);

			// sum of right part
			int sum2 = sumArr(arr, split + 1, hi);

			if (sum1 == sum2) {

				int lp = maxPoints(arr, lo, split);
				int rp = maxPoints(arr, split + 1, hi);

				return Math.max(lp, rp) + 1;
			}
		}

		return 0;
	}

	public static int sumArr(int[] arr, int lo, int hi) {

		int sum = 0;
		for (int i = lo; i <= hi; i++) {
			sum += arr[i];
		}
		return sum;
	}

}