package hackerBlocks;

import java.util.Scanner;

public class NKnights {

	static int c = 0;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		int ans=nKnights(new boolean[n][n], n, 0, 0, 0, "");
		System.out.println();
		System.out.println(ans);
		
//		System.out.println(c);
	}

	public static int nKnights(boolean[][] board, int tk, int kpsf, int row, int col, String ans) {

		if (kpsf == tk) {
			System.out.print(ans + " ");
			c++;
			return 1;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {
			return 0;
		}
		int count=0;
		if ( isItPossible(board, row, col)) {
			board[row][col] = true;
			count+=nKnights(board, tk, kpsf + 1, row, col + 1, ans + "{" + row + "-" + col + "} ");
			board[row][col] = false;
		}
		nKnights(board, tk, kpsf, row, col + 1, ans);

		return count;
	}

	private static boolean isItPossible(boolean[][] board, int row, int col) {
		int[] rowarr = { -1, -2, -2, -1 };
		int[] colarr = { 2, 1, -1, -2 };

		for (int i = 0; i < 4; i++) {

			int r = row + rowarr[i];
			int c = col + colarr[i];
			if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
				if (board[r][c]) {
					return false;
				}
			}

		}

		return true;
	}

}