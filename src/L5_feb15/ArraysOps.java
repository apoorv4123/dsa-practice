package L5_feb15;

import java.util.Scanner;

public class ArraysOps {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		System.out.println(max(arr));
		System.out.println(linearSearch(arr, 30));
		System.out.println(binarySearch(arr, 8));
		System.out.println();
		display(arr);
		System.out.println();
		subarrays(arr);
		System.out.println("---------------------------------------");
		sumSubarrays(arr);

//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the size of array:");
//		int n = s.nextInt();
//
//		int[] arr = new int[n];
//		System.out.println("Enter the elements of array:");
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = s.nextInt();
//		}
//		System.out.println("Element to be searched: ");
//		int item = s.nextInt();
//		
//		System.out.println("Element is preent at: ");
//		
//		System.out.println(binarySearch(arr, item));
//		s.close();

	}

	public static int[] takeInput() {
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

	public static int max(int[] arr) {
		// int max=Integer.MIN_VALUE;
		int max = arr[0];
		for (int val : arr) {
			if (val > max) {
				max = val;
			}
		}
		return max;
	}

	public static int linearSearch(int[] arr, int item) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item) {
				return i;
			}
		}
		return -1;
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

	public static void subarrays(int[] arr) {
//		for (int k = 0; k < arr.length; k++) {
//			for (int i = k; i < arr.length; i++) {
//				int sum=0;
//				for (int j = k; j <= i; j++) {
//					sum=sum+arr[j];
//					System.out.print(arr[j] + " ");
//				}
//				System.out.println("----"+sum+"----");
//				System.out.println();
//			}
//		}
		int start = 0;
		int end = arr.length - 1;
		for (int si = start; si <= end; si++) {
			for (int ei = si; ei < arr.length; ei++) {
				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}

	}

	public static void sumSubarrays(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		for (int si = start; si <= end; si++) {
			int sum = 0;
			for (int ei = si; ei < arr.length; ei++) {
				sum = sum + arr[ei];
				System.out.println(sum);
			}
			// System.out.println(sum);
		}
	}
}