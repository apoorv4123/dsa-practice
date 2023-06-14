package hackerBlocks_Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class chessBoardProblem2 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		char[] mp = createMinesPorts(SOE(n * n));

		int ans = chessBoard2(0, 0, n - 1, n - 1, "", mp);
		System.out.println();
		System.out.println(ans);

		s.close();
		
	}

	private static int chessBoard2(int cc, int cr, int ec, int er, String ans, char[] mp) {

		if (ec == cc && er == cr) {
			System.out.println(ans + "{" + cc + "-" + cr + "}");
			return 1;
		}

		if (cc > ec || cr > er) {
			return 0;
		}

		int count = 0;

		int val = cr * (ec + 1) + cc + 1;

		if (mp[val] == 'M') {
			return 0;
		} else if (mp[val] == 'P') {
			count += chessBoard2(ec, er, ec, er, ans + "{" + cc + "-" + cr + "}P", mp);
		}

		// knight
		count += chessBoard2(cc + 1, cr + 2, ec, er, ans + "{" + cc + "-" + cr + "}K", mp);
		count += chessBoard2(cc + 2, cr + 1, ec, er, ans + "{" + cc + "-" + cr + "}K", mp);

		// rook
		if (cc == 0 || cr == 0 || cc == ec || cr == er) {

			// horizontal
			for (int i = 1; i <= ec; i++) {
				count += chessBoard2(cc + i, cr, ec, er, ans + "{" + cc + "-" + cr + "}R", mp);
			}

			// vertical
			for (int i = 1; i <= er; i++) {
				count += chessBoard2(cc, cr + i, ec, er, ans + "{" + cc + "-" + cr + "}R", mp);
			}
		}

		// bishop
		if (cr == cc || cr + cc == er) {
			for (int i = 1; i <= er; i++) {
				count += chessBoard2(cc + i, cr + i, ec, er, ans + "{" + cc + "-" + cr + "}B", mp);
			}
		}
		return count;
	}

	public static char[] createMinesPorts(boolean[] primes) {

		int count = 1;

		char[] mp = new char[primes.length];

		for (int i = 0; i < primes.length - 1; i++) {

			if (primes[i]) {

				// odd : mine
				if (count % 2 == 1) {
					mp[i] = 'M';
				}
				// even : port
				else {
					mp[i] = 'P';
				}

				count++;
			}
		}
		System.out.println("----------------");
		int c = 1;
		for (char val : mp) {
			System.out.print(c + " " + val + " ");
			c++;
		}
		System.out.println();
		System.out.println("----------------");

		return mp;
	}

	public static boolean[] SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table]) {

				for (int mult = 2; table * mult <= n; mult++) {
					primes[table * mult] = false;
				}

			}
		}
		return primes;
	}

}