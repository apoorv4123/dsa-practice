package L5_feb15;

import java.util.Scanner;

public class barGraphArrays {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		int max = arr[0];
		for (int val : arr) {
			if (val > max) {
				max = val;
			}
		}
		for (int r = 0; r < max; r++) {
			for (int c = 0; c < n; c++) {
				if (max - r > arr[c]) {
					System.out.print("  ");
				} else
					System.out.print("* ");
			}
			System.out.println();
		}
	}
}
