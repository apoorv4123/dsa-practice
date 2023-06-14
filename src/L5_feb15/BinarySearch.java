package L5_feb15;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = s.nextInt();

		int[] arr = new int[n];
		System.out.println("Enter the elements of array:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}

		Arrays.sort(arr);

		System.out.println("Enter the item to be searched:");
		int item = s.nextInt();

		System.out.print("Index at which "+item+" is present is : ");
		System.out.println(binarySearch(arr, item));
	}

	public static int binarySearch(int[] arr, int item) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (item < arr[mid]) {
				high = mid - 1;
			} else if (item > arr[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
