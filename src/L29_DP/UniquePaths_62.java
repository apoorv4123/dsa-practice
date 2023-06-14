package L29_DP;

import java.util.Arrays;

public class UniquePaths_62 {

	public static void main(String[] args) {

		int col = 7;
		int row = 3;

//		System.out.println(UPRecursion(0, 0, row - 1, col - 1));

//		System.out.println(UPTD(0, 0, row - 1, col - 1, new int[row][col]));

		System.out.println(UPBU(row, col));

		System.out.println(UPBUSE(row, col));

	}

	public static int UPRecursion(int cr, int cc, int er, int ec) {

		if (cr > er || cc > ec) {
			return 0;
		}

		if (cc == ec && cr == er) {
			return 1;
		}

		int down = UPRecursion(cr + 1, cc, er, ec);
		int right = UPRecursion(cr, cc + 1, er, ec);

		int ans = down + right;

		return ans;

	}

	public static int UPTD(int cr, int cc, int er, int ec, int[][] storage) {

		if (cr > er || cc > ec) {
			return 0;
		}

		if (cc == ec && cr == er) {
			return 1;
		}

		if (storage[cr][cc] != 0) {
			return storage[cr][cc];
		}

		int down = UPTD(cr + 1, cc, er, ec, storage);
		int right = UPTD(cr, cc + 1, er, ec, storage);

		int ans = down + right;

		storage[cr][cc] = ans;

		return ans;

	}

	public static int UPBU(int er, int ec) {

		int[][] storage = new int[er][ec];

		for (int i = 0; i < storage.length; i++) {
			storage[i][ec - 1] = 1;
		}
		for (int i = 0; i < storage[0].length; i++) {
			storage[er - 1][i] = 1;
		}

		for (int cr = er - 2; cr >= 0; cr--) {
			for (int cc = ec - 2; cc >= 0; cc--) {
				storage[cr][cc] = storage[cr][cc + 1] + storage[cr + 1][cc];
			}
		}
		return storage[0][0];
	}

	public static int UPBUSE(int er, int ec) {

		int[] strg = new int[ec];

		Arrays.fill(strg, 1);

		for (int slide = 1; slide <= er - 1; slide++) {
			for (int col = ec - 2; col >= 0; col--) {
				strg[col] = strg[col] + strg[col + 1];
			}
			show(strg);
		}
		return strg[0];
	}

	public static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}