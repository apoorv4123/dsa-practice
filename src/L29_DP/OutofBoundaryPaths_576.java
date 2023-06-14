package L29_DP;

import java.util.Arrays;

public class OutofBoundaryPaths_576 {

	public static void main(String[] args) {

		int m = 1;
		int n = 3;
		int N = 3;
		long[][][] strg = new long[m][n][N];
		for (int r = 0; r < strg.length; r++) {
			for (int c = 0; c < strg[0].length; c++) {
				Arrays.fill(strg[r][c], -1);
			}
		}

		System.out.println((int) (12 % (Math.pow(10, 9) + 7)));

//		System.out.println(OOBPRec(m, n, N - 1, 0, 1, strg));

	}

	public static long OOBPRec(int m, int n, int N, int cr, int cc, long[][][] strg) {

		if (cr < 0 || cc < 0 || cr >= m || cc >= n) {
			return 1;
		}

		if (N < 0) {
			return 0;
		}

		if (strg[cr][cc][N] != -1) {
			return (int) strg[cr][cc][N];
		}

		long ans = 0;
		// up
		long up = OOBPRec(m, n, N - 1, cr - 1, cc, strg);

		// down
		long down = OOBPRec(m, n, N - 1, cr + 1, cc, strg);

		// left
		long left = OOBPRec(m, n, N - 1, cr, cc - 1, strg);

		// right
		long right = OOBPRec(m, n, N - 1, cr, cc + 1, strg);

		ans = up + down + left + right;

		strg[cr][cc][N] = ans;

		return ans;
	}

}