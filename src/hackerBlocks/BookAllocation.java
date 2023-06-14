package hackerBlocks;

import java.util.Scanner;

public class BookAllocation {

	public static void main(String[] args) {
		// O(nlogn) complexity

		Scanner s = new Scanner(System.in);

		int lo = 0;
		int hi = 0;

		int nob = s.nextInt();
		int nos = s.nextInt();

		int[] pages = new int[nob];
		for (int i = 0; i < nob; i++) {
			pages[i] = s.nextInt();
			hi += pages[i];
		}

		// logic
		int finalans = 0;

		while (lo <= hi) {// log n

			int mi = (lo + hi) / 2;

			if (isItPossibleToReaTheBooks(pages, nob, nos, mi)) {
				finalans = mi;
				hi = mi - 1;
			} else {
				lo = mi + 1;
			}
		}

		System.out.println(finalans);

		s.close();
	}

	public static boolean isItPossible(int[] pages, int nob, int nos, int mid) {

		int students = 1;
		int pagesread = 0;

		for (int i = 0; i < nob; i++) {

			if (pagesread + pages[i] <= mid) {
				pagesread += pages[i];
			} else {
				pagesread = 0;
				students++;
				if (students > nos) {
					return false;
				}
				i--;
			}
		}
		return true;
	}

	public static boolean isItPossibleToReaTheBooks(int[] pages, int nob, int nos, int mi) {
		// O(n)
		int stuents = 1;
		int pagesReab = 0;

		int i = 0;

		while (i < nob) {

			if (pagesReab + pages[i] <= mi) {
				pagesReab += pages[i];
				i++;
			} else {
				// new student
				stuents++;
				pagesReab = 0;
				// no i++ bcoz no book is read in else block only a new student comes

				if (stuents > nos) {
					return false;
				}
			}
		}
		// i increase ho ho k nob tk pahuch gya it means given nos were able to read
		// given nob
		return true;
	}

}
