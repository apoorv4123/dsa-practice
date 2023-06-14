package hackerBlocks;

import java.util.Scanner;

public class RainWaterTrapping {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int test = s.nextInt();

		while (test > 0) {

			int not = s.nextInt();// no. of towers

			int[] tower = new int[not];
			for (int t = 0; t < tower.length; t++) {
				tower[t] = s.nextInt();
			}

			System.out.println(BruteForceApproach(tower));
			System.out.println(OptimiseApproach(tower));
			test--;
		}

	}

	public static int BruteForceApproach(int[] arr) {
		int ans = 0;

		for (int b = 0; b < arr.length; b++) {

			// left max
			int lmax = Integer.MIN_VALUE;
			for (int l = b; l >= 0; l--) {
				if (arr[l] > lmax) {
					lmax = arr[l];
				}
			}

			// right max
			int rmax = Integer.MIN_VALUE;
			for (int r = b; r < arr.length; r++) {
				if (arr[r] > rmax) {
					rmax = arr[r];
				}
			}

			int watertrappedbybuil = Math.min(lmax, rmax) - arr[b];
			ans += watertrappedbybuil;
		}
		return ans;
	}

	public static int OptimiseApproach(int[] arr) {

		int sum = 0;

		int[] lmax = new int[arr.length];
		lmax[0] = arr[0];

		for (int l = 1; l < lmax.length; l++) {

			lmax[l] = Math.max(arr[l], lmax[l - 1]);

		}

//		for (int val : lmax) {
//			System.out.print(val + " ");
//		}

		int[] rmax = new int[arr.length];
		rmax[rmax.length - 1] = arr[arr.length - 1];

		for (int r = rmax.length - 2; r >= 0; r--) {

			rmax[r] = Math.max(arr[r], rmax[r + 1]);

		}

//		System.out.println();
//		for (int val : rmax) {
//			System.out.print(val + " ");
//		}

		for (int b = 0; b < arr.length; b++) {
			int pbc = Math.min(lmax[b], rmax[b]) - arr[b]; // present builing contribution
			sum += pbc;
		}

		return sum;
	}

}