package hackerBlocks;

import java.util.Scanner;

public class NextGreaterElement {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t > 0) {

			int sz = s.nextInt();
			int[] arr = new int[sz];

			for (int i = 0; i < sz; i++) {

				arr[i] = s.nextInt();

			}

			for (int i = 0; i < arr.length; i++) {

				int nge = check(arr, arr[i], i + 1);
				System.out.println(arr[i] + "," + nge);

			}

			t--;
		}

	}

	private static int check(int[] arr, int arri, int ip1) {
		if (ip1 == arr.length) {
			return -1;
		}
		if (arr[ip1] > arri) {
			return arr[ip1];
		} else {
			return check(arr, arri, ip1 + 1);
		}
	}

}
