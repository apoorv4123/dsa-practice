package L29_DP;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

//		System.out.println(FibRecursion(n));  // Will take time for n=50

//		System.out.println(FibTD(n, new int[n + 1])); // Stack overflow error for n=10^5

//		System.out.println(FibBU(n));

		System.out.println(FibBUSE(n));

		scn.close();

	}

	// TC : O(2^n) , SC : O(1)
	public static int FibRecursion(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = FibRecursion(n - 1);// fibonacci of n-1
		int fnm2 = FibRecursion(n - 2);// fibonacci of n-2

		int fn = fnm1 + fnm2;// fibonacci of n

		return fn;

	}

	// Top-down => TC : O(n) , SC : O(n) + Rec Extra Space
	public static int FibTD(int n, int[] storage) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (storage[n] != 0) {
			return storage[n];
		}

		int fnm1 = FibTD(n - 1, storage);
		int fnm2 = FibTD(n - 2, storage);

		int fn = fnm1 + fnm2;

		storage[n] = fn; // store

		return fn;

	}

	// Bottom-Up => TC : O(n) , SC : O(n)
	public static int FibBU(int n) {

		// array of size n+1
		int[] storage = new int[n + 1];

		// base case values fill
		storage[0] = 0;
		storage[1] = 1;

		// forward filling direction
		for (int i = 2; i < storage.length; i++) {
			storage[i] = storage[i - 1] + storage[i - 2];
		}

		return storage[n];
	}

	// TC : O(n) , SC : O(1)
	public static int FibBUSE(int n) {

		int[] storage = new int[2];

		storage[0] = 0;
		storage[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {

			int sum = storage[0] + storage[1];
			storage[0] = storage[1];
			storage[1] = sum;

		}

		return storage[1];
	}
	
}