package L6_feb16;

import java.util.Scanner;

public class ArrayOps {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		//int[] arr = takeInput();
	//	int[] arr= {0,3,1,4,5,2};
		int[] arr= {1,2,3,4,5};
		System.out.println("My Array:");
		display(arr);
//		System.out.println();
//		System.out.println("Reversed Array:");
//		reverseArray(arr);
//		display(arr);
//		System.out.println();
//		reverseArray(arr);
//		 int[] narr=inverseArray(arr);
//		 System.out.println("Inversed Array:");
//		 display(narr);
//		 System.out.println();
		 System.out.println("Rotated Array:");
		rotateArray(arr, 1);
		display(arr);

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

	public static int[] inverseArray(int[] arr) {
		int[] narr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			//int item = arr[i];
			narr[arr[i]] = i;
		}
		return narr;
	}

	public static void reverseArray(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			Swap(arr, arr.length - i - 1, i);
		}
	}

	public static void rotateArray(int[] arr, int rot) {
		rot = rot % arr.length;
		if (rot < 0) {
			rot += arr.length;
		}
		int k = 1;
		while (k <= rot) {
			int item = arr[arr.length - 1];
			for (int i = arr.length - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = item;
			k++;
		}
	}

	public static void Swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
