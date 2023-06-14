package hackerBlocks;

import java.util.Scanner;

public class FormBiggestNumber {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		
		while (test > 0) {
			int size = s.nextInt();
			int[] arr = new int[size];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}
			
			bubbleSort(arr);

			for (int val : arr) {
				System.out.print(val);
			}

			System.out.println();

			test--;
		}

		s.close();
	}

	public static void bubbleSort(int[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (compare(arr[j], arr[j + 1])) {
					swap(arr, j, j + 1);
				}
			}
		}

	}

	private static boolean compare(int one, int two) {

		String onetwo = one + "" + two;
		String twoone = two + "" + one;

		if (twoone.compareTo(onetwo) > 0) {
			return true;
		}
		return false;
	}

	public static void swap(int[] arr, int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}