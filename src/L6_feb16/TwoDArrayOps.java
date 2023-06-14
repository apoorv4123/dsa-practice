package L6_feb16;

import java.util.Scanner;

public class TwoDArrayOps {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// int[][] arr=make2darray();
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Array Display: ");
		display(arr);
		System.out.println("Array WaveDisplay Row-wise: ");
		waveDisplayRowwise(arr);
		System.out.println("Array WaveDisplay Column-wise: ");
		waveDisplayColumnwise(arr);
		System.out.println("Array SpiralDisplay anti-clockwise");
		spiralDisplay2Darr(arr);
	}

	public static int[][] make2darray() {
		int rows = s.nextInt();
		int cols = s.nextInt();
		int[][] arr = new int[rows][cols];
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = s.nextInt();
			}
		}
		return arr;
	}

	public static void display(int[][] arr) {
		for (int[] val : arr) {
			for (int val1 : val) {
				System.out.print(val1 + " ");
			}
			System.out.println();
		}
	}

	public static void waveDisplayRowwise(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < arr[row].length; col++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int col = arr[row].length - 1; col >= 0; col--) {
					System.out.print(arr[row][col] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void waveDisplayColumnwise(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			// column even up to down loop
			// column odd down to up loop
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(arr[row][col] + " ");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(arr[row][col] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void spiralDisplay2Darr(int[][] arr) {
		int minrow = 0;
		int mincol = 0;
		int maxrow = arr.length - 1;
		int maxcol = arr[0].length - 1;
		int totalnos = arr.length * arr[0].length;
		int count = 1;
		while (count <= totalnos) {
			for (int i = minrow; i <= maxrow && count <= totalnos; i++) {
				System.out.print(arr[i][mincol] + " ");
				count++;
			}
			mincol++;
			for (int i = mincol; i <= maxcol && count <= totalnos; i++) {
				System.out.print(arr[maxrow][i] + " ");
				count++;
			}
			maxrow--;
			for (int i = maxrow; i >= minrow && count <= totalnos; i--) {
				System.out.print(arr[i][maxcol] + " ");
				count++;
			}
			maxcol--;
			for (int i = maxcol; i >= mincol && count <= totalnos; i--) {
				System.out.print(arr[minrow][i] + " ");
				count++;
			}
			minrow++;
		}
	}
}