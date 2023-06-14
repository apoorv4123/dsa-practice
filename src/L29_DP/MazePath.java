package L29_DP;

import java.util.Arrays;

public class MazePath {

	public static void main(String[] args) {

		int n = 50;

//		System.out.println(MPRecursive(0, 0, n, n));
//		System.out.println(MPTD(0, 0, n, n, new int[n + 1][n + 1]));
//		System.out.println(MPBU1(n, n));
//		System.out.println(MPBU2(n, n));
		System.out.println(MPBUSE(3, 4));
	}

	public static int MPRecursive(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		// horizontal
		int ch = MPRecursive(cr, cc + 1, er, ec);

		// vertical
		int cv = MPRecursive(cr + 1, cc, er, ec);

		return ch + cv;

	}

	public static int MPTD(int cr, int cc, int er, int ec, int[][] storage) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (storage[cr][cc] != 0) {
			return storage[cr][cc];
		}

		// horizontal
		int ch = MPTD(cr, cc + 1, er, ec, storage);

		// vertical
		int cv = MPTD(cr + 1, cc, er, ec, storage);

		storage[cr][cc] = ch + cv;

		return ch + cv;

	}

	public static int MPBU1(int er, int ec) {

		int[][] storage = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					storage[row][col] = 1;
				} else {
					storage[row][col] = storage[row][col + 1] + storage[row + 1][col];
				}

			}
		}
		return storage[0][0];
	}

	public static int MPBU2(int er, int ec) {

		int[][] storage = new int[er + 1][ec + 1];

		for (int i = 0; i < storage[0].length; i++) {
			storage[er][i] = 1;
		}
		for (int i = 0; i < storage.length; i++) {
			storage[i][ec] = 1;
		}

		for (int row = er - 1; row >= 0; row--) {

			for (int col = ec - 1; col >= 0; col--) {

				storage[row][col] = storage[row][col + 1] + storage[row + 1][col];

			}
		}
		return storage[0][0];
	}

	public static int MPBUSE(int er, int ec) {

		int[] storage = new int[ec + 1];

		Arrays.fill(storage, 1);

		for (int slide = 1; slide <= er; slide++) {

			for (int col = storage.length - 2; col >= 0; col--) {
				storage[col] = storage[col] + storage[col + 1];
			}

		}

		return storage[0];

	}
}