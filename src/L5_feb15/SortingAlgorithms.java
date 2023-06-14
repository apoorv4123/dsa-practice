package L5_feb15;

import java.util.Scanner;

public class SortingAlgorithms {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = makearray();

//		bubbleSort(arr);
//		display(arr);

		selectionSort(arr);
		display(arr);

//		int[] arr = { 88, 11, 44, 99, 33 };
//		insertionSort(arr);
//		display(arr);

	}

	public static int[] makearray() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	public static void bubbleSort(int[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {

			for (int j = 0; j < arr.length - 1 - counter; j++) {

				if (arr[j] > arr[j + 1]) {
					Swap(arr, j, j + 1);
				}
			}
		}
		
	}

	public static void selectionSort(int[] arr) {
		for (int counter = 0; counter < arr.length; counter++) {
			int min = counter;
			for (int j = counter + 1; j < arr.length; j++) {
				if (arr[j] > arr[min]) {
					min = j;
				}
				Swap(arr, min, j);
			}
		}
	}

	public static void Swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void insertionSort(int[] arr) {

		for (int counter = 1; counter <= arr.length - 1; counter++) {

			int val = arr[counter];

			int j = counter - 1;
			while (j >= 0 && arr[j] > val) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = val;
		}
	}

}