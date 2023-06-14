package hackerBlocks;

import java.util.Scanner;

public class PaintersPartition {

	public static void main(String[] args) {
		// O(nlogn) complexity

		Scanner s = new Scanner(System.in);

		int lo = 0;
		int hi = 0;

		int nop = s.nextInt();// no. of painters
		int nob = s.nextInt();// no. of boards

		int[] board = new int[nob];
		for (int i = 0; i < nob; i++) {
			board[i] = s.nextInt();
			hi += board[i];
		}

		// logic
		int finalans = 0;

		while (lo <= hi) {// log n

			int mi = (lo + hi) / 2;

			if (isItPossibleToPaintTheBoards(board, nop, nob, mi)) {
				finalans = mi;
				hi = mi - 1;
			} else {
				lo = mi + 1;
			}
		}

		System.out.println(finalans);
	}

	public static boolean isItPossibleToPaintTheBoards(int[] board, int nop, int nob, int mi) {
		// O(n)
		int painters = 1;
		int unitsofboardsPainted = 0;

		int i = 0;

		while (i < nob) {

			if (unitsofboardsPainted + board[i] <= mi) {
				unitsofboardsPainted += board[i];
				i++;
			} else {
				painters++;
				unitsofboardsPainted = 0;
				// no i++ bcoz no book is read in else block only a new student comes

				if (painters > nop) {
					return false;
				}
			}
		}
		// i increase ho ho k nob tk pahuch gya it means given nop were able to paint
		// given nob
		return true;
	}

}
