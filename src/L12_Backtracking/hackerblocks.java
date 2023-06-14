package L12_Backtracking;

import java.util.Scanner;

public class hackerblocks {
	static int count = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

//		int n = s.nextInt();
//		int[] arr = new int[n];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = s.nextInt();
//		}
//		int target = s.nextInt();
//		subsetProblem(arr, 0, 0, target, " ");
//		System.out.println();
//		System.out.println(" " + count);

//		chessboardProblem(0, 0, 2, 2, "");

//		towersOfHanoi(5, 'A', 'B', 'C');

//		int n = s.nextInt();
//		int[][] ques = new int[n][n];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				ques[i][j] = s.nextInt();
//			}
//		}
//		sudokuSolver(ques, 0, 0, "");

		s.close();
	}

	public static void chessboardProblem(int cr, int cc, int er, int ec, String ans) {
		if (cc == ec && cr == er) {
			count++;
			System.out.println(count + "." + ans + "{" + cr + "-" + cc + "} ");
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}

		// Moves of Knight
		chessboardProblem(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}" + "K");
		chessboardProblem(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}" + "K");

		// Moves of rook
		if (cr == 0 || cc == 0 || cr == er || cc == ec) {
			for (int i = 1; i <= ec; i++) {
				chessboardProblem(cr, cc + i, er, ec, ans + "{" + cr + "-" + cc + "}" + "R");
			}
			for (int i = 1; i <= er; i++) {
				chessboardProblem(cr + i, cc, er, ec, ans + "{" + cr + "-" + cc + "}" + "R");
			}
		}

		// Moves of Bishop
		if (cr == cc || cr + cc == ec) {
			for (int i = 1; i <= er; i++)
				chessboardProblem(cr + i, cc + i, er, ec, ans + "{" + cr + "-" + cc + "}" + "B");
		}
	}

	public static void subsetProblem(int[] arr, int vix, int curr, int tgt, String ans) {
		if (curr == tgt) {
			count++;
			System.out.print(ans);
			return;
		}
		if (vix == arr.length) {
			return;
		}
		subsetProblem(arr, vix + 1, curr + arr[vix], tgt, ans + arr[vix] + " ");
		subsetProblem(arr, vix + 1, curr, tgt, ans);
	}

	public static void towersOfHanoi(int n, char st, char end, char help) {
		if (n == 1) {
			System.out.println("Moving ring " + n + " from " + st + " to " + end);
			return;
		}
		towersOfHanoi(n - 1, st, help, end);
		System.out.println("Moving ring " + n + " from " + st + " to " + end);
		towersOfHanoi(n - 1, help, end, st);

	}

	public static void sudokuSolver(int[][] ques, int row, int col, String ans) {

		if (col == ques[0].length) {
			System.out.println(ans);
			row++;
			col = 0;
		}
		if (row == ques.length) {
			return;
		}
		if (ques[row][col] != 0) {
			sudokuSolver(ques, row, col + 1, ans + ques[row][col] + " ");
		} else {
			for (int num = 1; num <= 9; num++) {
				if (isItPossible(ques, row, col, num)) {
					ques[row][col] = num;
					sudokuSolver(ques, row, col + 1, ans + num + " ");
					ques[row][col] = 0;
				}
			}
		}
	}

	public static int[][] sudoku(int[][] ques, int row, int col) {
		if (row == ques.length) {
			if (check(ques)) {
				return ques;
			}
		}
		if (col == ques[0].length) {
			row++;
			col = 0;
		}
		int[][] rr = new int[ques.length][ques[0].length];
		for (int i = 0; i < ques.length; i++) {
			rr[i] = ques[i];
		}

		if (ques[row][col] == 0) {
			for (int i = 0; i <= 9; i++) {
				if (isItPossible(ques, row, col, i)) {
					ques[row][col] = i;
					rr = sudoku(ques, row, col + 1);
					ques[row][col] = 0;
				}
			}
		} else {

		}
		return rr;
	}

	public static boolean check(int[][] ques) {

		return true;
	}

	public static boolean isItPossible(int[][] ques, int row, int col, int num) {
		// row
		for (int r = row, c = 0; c < ques[0].length; c++) {
			if (ques[r][c] == num) {
				return false;
			}
		}
		// column
		for (int r = 0, c = col; r < ques.length; r++) {
			if (ques[r][c] == num) {
				return false;
			}
		}
		if (row >= 0 && row < 3) {
			if (col >= 0 && col < 3) {
				for (int r = row; r < 3; r++) {
					for (int c = col; c < 3; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			} else if (col >= 3 && col < 6) {
				for (int r = row; r < 3; r++) {
					for (int c = col; c < 6; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			} else if (col >= 6 && col < 9) {
				for (int r = row; r < 3; r++) {
					for (int c = col; c < 9; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			}
		}

		else if (row >= 3 && row < 6) {
			if (col >= 0 && col < 3) {
				for (int r = row; r < 6; r++) {
					for (int c = col; c < 3; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			} else if (col >= 3 && col < 6) {
				for (int r = row; r < 6; r++) {
					for (int c = col; c < 6; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			} else if (col >= 6 && col < 9) {
				for (int r = row; r < 6; r++) {
					for (int c = col; c < 9; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			}
		}

		else if (row >= 6 && row < 9) {
			if (col >= 0 && col < 3) {
				for (int r = row; r < 9; r++) {
					for (int c = col; c < 3; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			} else if (col >= 3 && col < 6) {
				for (int r = row; r < 9; r++) {
					for (int c = col; c < 6; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			}
			if (col >= 6 && col < 9) {
				for (int r = row; r < 3; r++) {
					for (int c = col; c < 9; c++) {
						if (ques[r][c] == num) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}