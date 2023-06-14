package hackerBlocks;

import java.util.Arrays;
import java.util.Scanner;

public class ques {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			int nob = s.nextInt();
			int nos = s.nextInt();
			int sum = 0;
			int[] pages = new int[nob];
			for (int i = 0; i < nob; i++) {
				pages[i] = s.nextInt();
				sum += pages[i];
			}

			int lo = 0;
			int hi = sum;
			int ans = 0;
			while (lo <= hi) {
				int mi = (lo + hi) / 2;
				if (isPossible(pages, nob, nos, mi)) {
					hi = mi - 1;
					ans = mi;
				} else {
					lo = mi + 1;
				}
			}
			System.out.println(ans);
			t--;
		}
	}

	private static boolean isPossible(int[] pages, int nob, int nos, int mi) {
		int i = 0;// i enotes the number of books which have been rea
		int stuents = 1;
		int pagesreasofar = 0;
		while (i < nob) {
			if (pagesreasofar + pages[i] <= mi) {
				pagesreasofar += pages[i];
				i++;
			} else {
				stuents++;
				if (stuents > nos) {
					return false;
				}
				pagesreasofar = 0;
				// else case m books rea nhi ki gyi, bss nya stuent aaya
			}
		}
		return true;
	}

	public static int aggressiveCows(int[] stall, int nos, int noc) {
		int ans = 0;
		for (int i = 0; i < stall[stall.length - 1] - stall[0]; i++) {
			if (isItPossible(stall, noc, 0, 0, i)) {
				ans = i;
			}
		}
		return ans;
	}

	public static boolean isItPossible(int[] stall, int noc, int cpsf, int laststall, int val) {
		cpsf = 1;
		laststall = stall[0];
		for (int i = 1; i < stall.length; i++) {
			if (stall[i] - laststall >= val) {
				laststall = stall[i];
				cpsf++;
				if (cpsf == noc) {
					return true;
				}
			}
		}
		return false;
	}
}
