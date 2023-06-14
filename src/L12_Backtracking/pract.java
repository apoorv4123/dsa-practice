package L12_Backtracking;

public class pract {

	public static void main(String[] args) {
//		queencomb(new boolean[4], 2, 0, "",0);
		coinchange(new int[] { 2, 3, 5, 6 }, 10, 0, "");
//		queenCombinationQueenRespect(new boolean[4], 2, 0, "", 0);
//		queenCombinationBoxRespect(new boolean[4], 0, 2, 0, "");
//		coinChangeCoinRespect(new int[] { 2, 3, 5, 6 }, 10, 0, "");
	}

	public static void queenCombinationQueenRespect(boolean[] box, int tq, int qpsf, String ans, int lbv) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		for (int b = lbv; b < box.length; b++) {
			if (!box[b]) {
				box[b] = true;
				queenCombinationQueenRespect(box, tq, qpsf + 1, ans + "q" + qpsf + "b" + b, b);
				box[b] = false;
			}
		}
	}

	public static void queenCombinationBoxRespect(boolean[] box, int i, int tq, int qpsf, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (i == box.length) {
			return;
		}
		box[i] = true;
		queenCombinationBoxRespect(box, i + 1, tq, qpsf + 1, ans + "b" + i);
		box[i] = false;
		queenCombinationBoxRespect(box, i + 1, tq, qpsf, ans);
	}

	public static void coinChangeCoinRespect(int[] coins, int target, int ix, String ans) {
		if (target == 0) {
			System.out.println(ans);
			return;
		}
		if (ix == coins.length || target < 0) {
			return;
		}
		coinChangeCoinRespect(coins, target - coins[ix], ix, ans + coins[ix]);
		coinChangeCoinRespect(coins, target, ix + 1, ans);
	}

	public static void queencomb(boolean[] boar, int tq, int qpsf, String ans, int lv) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		for (int i = lv; i < boar.length; i++) {
			if (boar[i] == false) {
				boar[i] = true;
				queencomb(boar, tq, qpsf + 1, ans + "q" + qpsf + "b" + i + " ", i + 1);
				boar[i] = false;
			}
		}
	}

	public static void coinchange(int[] denom, int amount, int lastdenomidx, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0) {
			return;
		}

		for (int i = lastdenomidx; i < denom.length; i++) {
			coinchange(denom, amount - denom[i], i, ans + denom[i] + " ");
		}

	}

	public static void queencomb2d(boolean[][] boar, int row, int col, int tq, int qpsf, String ans) {
		if (row == boar.length) {
			System.out.println(ans);
			return;
		}
		if (col > boar[0].length) {
			row++;
			col = 0;
		}
		if (boar[row][col] == false) {
			boar[row][col] = true;
			queencomb2d(boar, row, col + 1, tq, qpsf + 1, ans + "(" + row + "," + col + ") ");
			boar[row][col] = false;
		}
		queencomb2d(boar, row, col + 1, tq, qpsf, ans);
	}

}