package L29_DP;

import java.util.Arrays;

public class MPDiagonal {

	public static void main(String[] args) {

		int er = 20;
		int ec = 20;

//		System.out.println(MPDRecursive(0, 0, er, ec));
		int[][] strg = new int[er + 1][ec + 1];
		System.out.println(MPDTD(0, 0, er, ec, strg));

//		for(int i=0;i<strg.length;i++) {
//			for(int j=0;j<strg[0].length;j++) {
//				System.out.print(strg[i][j]+"  ");
//			}
//			System.out.println();
//		}

		System.out.println(MPDBU(er, ec));
		System.out.println(MPDBUSE(er, ec));

	}

	public static int MPDRecursive(int cr, int cc, int er, int ec) {

		if (cc == ec && cr == er) {
			return 1;
		}

		if (cc > ec || cr > er) {
			return 0;
		}

		// horizontal
		int ch = MPDRecursive(cr, cc + 1, er, ec);

		// vertical
		int cv = MPDRecursive(cr + 1, cc, er, ec);

		// diagonal
		int cd = MPDRecursive(cr + 1, cc + 1, er, ec);

		return ch + cv + cd;
	}

	public static int MPDTD(int cr, int cc, int er, int ec, int[][] storage) {

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
		int ch = MPDTD(cr, cc + 1, er, ec, storage);

		// vertical
		int cv = MPDTD(cr + 1, cc, er, ec, storage);

		// diagonal
		int cd = MPDTD(cr + 1, cc + 1, er, ec, storage);

		storage[cr][cc] = ch + cv + cd;

		return ch + cv + cd;
	}

	public static int MPDBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col + 1] + strg[row][col + 1] + strg[row + 1][col];
				}
			}

		}

//		for (int i = 0; i < strg.length; i++) {
//			for (int j = 0; j < strg[0].length; j++) {
//				System.out.print(strg[i][j] + "\t");
//			}
//			System.out.println();
//		}

		return strg[0][0];

	}

	public static int MPDBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		int diag = 0;

		for (int slide = 1; slide <= er; slide++) {

			for (int c = ec; c >= 0; c--) {

				if (c == ec) {
					strg[c] = 1;
					diag = 1;
				} else {
					int val = strg[c] + strg[c + 1] + diag;
					diag = strg[c];
					strg[c] = val;
				}
			}
		}
		return strg[0];
	}
}