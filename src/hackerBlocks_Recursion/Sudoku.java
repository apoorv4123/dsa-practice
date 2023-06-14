package hackerBlocks_Recursion;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {

//	9
//	5 3 0 0 7 0 0 0 0 
//	6 0 0 1 9 5 0 0 0 
//	0 9 8 0 0 0 0 6 0 
//	8 0 0 0 6 0 0 0 3 
//	4 0 0 8 0 3 0 0 1 
//	7 0 0 0 2 0 0 0 6 
//	0 6 0 0 0 0 2 8 0 
//	0 0 0 4 1 9 0 0 5 
//	0 0 0 0 8 0 0 7 9 

//		9
//		5 3 0 0 7 0 0 0 0 
//		6 0 0 1 9 5 0 0 0 
//		0 9 8 0 0 0 0 6 0 
//		8 0 0 0 6 0 0 0 3 
//		4 0 0 8 0 3 0 0 1 
//		7 0 0 0 2 0 0 0 6 
//		0 6 0 0 0 0 2 8 0 
//		0 0 0 4 1 9 0 0 5 
//		0 0 0 0 8 0 0 0 0 

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int[][] arr = new int[n][n];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		if (!sudoku(arr, 0, 0)) {
			System.out.println("Not Possible");
		}

		s.close();

	}

	public static boolean sudoku(int[][] arr, int row, int col) {

		if (col == arr[0].length) {
			row++;
			col = 0;
		}
		if (row == arr.length) {
			display(arr);
			System.out.println();
			return true;
		}

		if (arr[row][col] != 0) {
			return sudoku(arr, row, col + 1);
		}

		boolean ans = true;
		for (int i = 1; i <= arr.length; i++) {
			if (isItSafe(arr, row, col, i)) {
				arr[row][col] = i;
				ans = sudoku(arr, row, col + 1);
				arr[row][col] = 0;
			}
		}
		return ans;
	}

	private static boolean isItSafe(int[][] arr, int row, int col, int num) {

		if (isItSafeRow(arr, row, num) && isItSafeCol(arr, col, num) && isItSafeCell(arr, row, col, num)) {
			return true;
		}
		return false;
	}

	private static boolean isItSafeCol(int[][] arr, int col, int num) {
		for (int r = 0; r < arr.length; r++) {
			if (arr[r][col] == num) {
				return false;
			}
		}
		return true;
	}

	private static boolean isItSafeCell(int[][] arr, int row, int col, int num) {

		// block starting row
		int bsr = row - row % 3;
		// block starting column
		int bsc = col - col % 3;

		for (int r = bsr; r < bsr + 3; r++) {
			for (int c = bsc; c < bsc + 3; c++) {
				if (arr[r][c] == num) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isItSafeRow(int[][] arr, int row, int num) {

		for (int c = 0; c < arr[0].length; c++) {
			if (arr[row][c] == num) {
				return false;
			}
		}
		return true;
	}

	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}