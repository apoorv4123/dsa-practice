package L29_DP;

import java.util.Scanner;

public class climbingStairs_70 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
//		System.out.println(CSRecursion(n));
		System.out.println(CSTD(n, new int[n + 1]));
		System.out.println(CSBU(n));
		System.out.println(CSBUSE(n));
		s.close();
	}

	public static int CSRecursion(int n) {

		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		int onestep = CSRecursion(n - 1);
		int twostep = CSRecursion(n - 2);

		return onestep + twostep;

	}

	public static int CSTD(int n, int[] storage) {

		if (n < 0) {
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		if (storage[n] != 0) {
			return storage[n];
		}

		int onestep = CSTD(n - 1, storage);
		int twostep = CSTD(n - 2, storage);

		int ans = onestep + twostep;

		storage[n] = ans;

		return ans;

	}

	public static int CSBU(int n) {

		int[] arr = new int[n + 1];
		arr[0] = 1;
		for (int col = 1; col < arr.length; col++) {

			int colm1 = arr[col - 1];
			int colm2 = 0;
			if (col - 2 >= 0) {
				colm2 = arr[col - 2];
			}

			int ans = colm1 + colm2;
			arr[col] = ans;
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}

		return arr[n];

	}

	public static int CSBUSE(int n) {

		int[] storage = new int[2];

		storage[0] = 1;

		for (int i = 1; i <= n + 1; i++) {
			int sum = storage[0] + storage[1];
			storage[0] = storage[1];
			storage[1] = sum;
			System.out.println(i + " . " + storage[0] + "-" + storage[1]);
		}

		return storage[1];

	}

}
