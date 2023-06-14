package hackerBlocks;

import java.util.Arrays;
import java.util.Scanner;

public class TargetSum {

// Pair of Roses/ Target sum pair
//if your given array is not sorted the first sort it
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		Arrays.sort(arr); // O(nlogn)
		int target = s.nextInt();

//		targetSumPair(arr, target); // O(n^2)
//		targetSumPair2PtrApproach(arr, target);
//		System.out.println();
//		targetSumPairMaxDifferencePair(arr, target);
//		System.out.println();
//		targetSumPairMinDifferencePair(arr, target);

		targetSumTriplet(arr, target);
	}

	public static void targetSumPair(int[] arr, int target) {

		for (int one = 0; one < arr.length - 1; one++) {
			for (int two = one + 1; two < arr.length; two++) {
				if (arr[one] + arr[two] == target) {
					System.out.println(arr[one] + " and " + arr[two]);
				}
			}
		}
	}

	public static void targetSumPair2PtrApproach(int[] arr, int target) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			if (arr[lo] + arr[hi] > target) {
				hi--;
			} else if (arr[lo] + arr[hi] < target) {
				lo++;
			} else {
				System.out.println(arr[lo] + " and " + arr[hi]);
				lo++;
				hi--;
			}
		}

	}

	public static void targetSumPairMaxDifferencePair(int[] arr, int target) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo < hi) {
			if (arr[lo] + arr[hi] > target) {
				hi--;
			} else if (arr[lo] + arr[hi] < target) {
				lo++;
			} else {
				System.out.println(arr[lo] + " and " + arr[hi]);
				lo++;
				hi--;
				break;
			}
		}
	}

	public static void targetSumPairMinDifferencePair(int[] arr, int target) {

		int lo = 0;
		int hi = arr.length - 1;

		int ansi = 0;
		int ansj = 0;

		while (lo < hi) {
			if (arr[lo] + arr[hi] > target) {
				hi--;
			} else if (arr[lo] + arr[hi] < target) {
				lo++;
			} else {

				ansi = arr[lo];
				ansj = arr[hi];

				lo++;
				hi--;
			}
		}

		System.out.println(ansi + " and " + ansj);
	}

	public static void targetSumTriplet(int[] arr, int target) {

		for (int lo = 0; lo < arr.length; lo++) {

			int mid = lo + 1;
			int hi = arr.length - 1;

			while (mid < hi) {
				if (arr[lo] + arr[mid] + arr[hi] > target) {
					hi--;
				} else if (arr[lo] + arr[mid] + arr[hi] < target) {
					mid++;
				} else {
					System.out.println(arr[lo] + " " + arr[mid] + " " + arr[hi]);
					mid++;
					hi--;
				}
			}
		}
	
	}

}