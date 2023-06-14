package hackerBlocks_Recursion;

public class chessBoardProblem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = problem(0, 0, 2, 2, "");
		System.out.println();
		System.out.println(ans);
	}

	public static int problem(int cc, int cr, int ec, int er, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans + "{" + cc + "-" + cr + "}");
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		// knight
		count += problem(cc + 2, cr + 1, ec, er, ans + "{" + cc + "-" + cr + "}K");
		count += problem(cc + 1, cr + 2, ec, er, ans + "{" + cc + "-" + cr + "}K");

		// rook
		if (cc == 0 || cr == 0 || cc == ec || cr == er) {
			
			// horizontal
			for (int step = 1; step <= ec ; step++) {
				count += problem(cc, cr + step, ec, er, ans + "{" + cc + "-" + cr + "}R");
			}
			
			// vertical
			for (int step = 1; step <= er ; step++) {
				count += problem(cc + step, cr, ec, er, ans + "{" + cc + "-" + cr + "}R");
			}
		}

		// bishop
		if (cc == cr || cr + cc == er) {
			for (int i = 1; i <= ec; i++) {
				count += problem(cc + i, cr + i, ec, er, ans + "{" + cc + "-" + cr + "}B");
			}
		}

		return count;
	}

//	{0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2} {0-0}R{0-1}K{2-2} {0-0}R{0-1}R{0-2}R{1-2}R{2-2} {0-0}R{0-1}R{0-2}R{2-2} {0-0}R{0-1}R{1-1}B{2-2} {0-0}R{0-1}R{2-1}R{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2} {0-0}R{1-0}R{1-1}B{2-2} {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2} {0-0}R{1-0}R{2-0}R{2-2} {0-0}R{2-0}R{2-1}R{2-2} {0-0}R{2-0}R{2-2} {0-0}B{1-1}B{2-2} {0-0}B{2-2

}