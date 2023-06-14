package L12_Backtracking;

public class Questions {

	public static void main(String[] args) {

//		twoQueensPerQueenRespect(new boolean[4], 2, 0, "");
//		twoQueensCombQueenRespect1d(new boolean[4], 2, 0, 0, "");
//		twoQueensCombBoxRespect(new boolean[4], 2, 0, 0, "");
//		queensCombBoxRespect2d(new boolean[2][4], 2, 0, 0, 0, "");
		queensCombBoxRespect2dkill(new boolean[3][4], 3, 0, 0, 0, "");

	}

	public static void twoQueensPerQueenRespect1d(boolean[] box, int tq, int qpsf, String ans) {

		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < box.length; i++) {
			if (!box[i]) {
				box[i] = true;
				twoQueensPerQueenRespect1d(box, tq, qpsf + 1, ans + "q" + (qpsf + 1) + "b" + i + " ");
				box[i] = false;
			}
		}

	}

	public static void twoQueensCombQueenRespect1d(boolean[] box, int tq, int qpsf, int lbv, String ans) {

		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		for (int i = lbv; i < box.length; i++) {
			if (!box[i]) {
				box[i] = true;
				twoQueensCombQueenRespect1d(box, tq, qpsf + 1, i, ans + "q" + (qpsf + 1) + "b" + i + " ");
				box[i] = false;
			}
		}

	}

	public static void twoQueensCombBoxRespect1d(boolean[] box, int tq, int qpsf, int idx, String ans) {

		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		if (idx == box.length) {
			return;
		}

		// place
		box[idx] = true;
		twoQueensCombBoxRespect1d(box, tq, qpsf + 1, idx + 1, ans + "b" + idx);
		box[idx] = false;

		// not place
		twoQueensCombBoxRespect1d(box, tq, qpsf, idx + 1, ans);

	}

	public static void queensCombBoxRespect2d(boolean[][] box, int tq, int qpsf, int row, int col, String ans) {

		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		if (col == box[0].length) {
			row++;
			col = 0;
		}

		if (row == box.length) {
			return;
		}

		// place
		if (!box[row][col]) {
			box[row][col] = true;
			queensCombBoxRespect2d(box, tq, qpsf + 1, row, col + 1, ans + "b" + row + col + " ");
			box[row][col] = false;
		}

		// not place
		queensCombBoxRespect2d(box, tq, qpsf, row, col + 1, ans);
	}

	public static void queensCombBoxRespect2dkill(boolean[][] box, int tq, int qpsf, int row, int col, String ans) {

		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		if (col == box[0].length) {
			row++;
			col = 0;
		}

		if (row == box.length) {
			return;
		}

		// place
		if (isItSafeToPlaceQueen(box, row, col)) {
			box[row][col] = true;
			queensCombBoxRespect2dkill(box, tq, qpsf + 1, row, col + 1, ans + "b" + row + col + " ");
			box[row][col] = false;
		}

		// not place
		queensCombBoxRespect2dkill(box, tq, qpsf, row, col + 1, ans);
	}

	private static boolean isItSafeToPlaceQueen(boolean[][] box, int row, int col) {

		// horizontal
		for (int c = col; c >= 0; c--) {
			if (box[row][c]) {
				return false;
			}
		}

		// vertical
		for (int r = row; r >= 0; r--) {
			if (box[r][col]) {
				return false;
			}
		}

		// diagonal left
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (box[r][c]) {
				return false;
			}
		}

		// diagonal right
		for (int r = row, c = col; r >= 0 && c < box[0].length; r--, c++) {
			if (box[r][c]) {
				return false;
			}
		}

		return true;
	}

}