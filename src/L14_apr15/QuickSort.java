package L14_apr15;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 50, 40, 80, 90, 70, 10, 30, 60, 100 };
		quickSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int left = lo;
		int right = hi;

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;
			}
		}

		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
