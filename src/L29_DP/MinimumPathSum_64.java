package L29_DP;

public class MinimumPathSum_64 {

	public static void main(String[] args) {
	
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(MPSRec(grid, 0, 0));
		
		int[][] strg = new int[grid.length][grid[0].length];
		
		System.out.println(MPSTd(grid, 0, 0, strg));
		
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				System.out.print(strg[r][c] + "\t");
			}
			System.out.println();
		}
		
//		System.out.println(MPSBU(grid));
	}

	public static int MPSRec(int[][] grid, int cr, int cc) {

		if (cr == grid.length || cc == grid[0].length) {
			return Integer.MAX_VALUE;
		}

		if (cr == grid.length - 1 && cc == grid[0].length - 1) {
			return grid[cr][cc];
		}

		int down = MPSRec(grid, cr + 1, cc);
		int right = MPSRec(grid, cr, cc + 1);

		int ans = Math.min(down, right) + grid[cr][cc];

		return ans;

	}

	public static int MPSTd(int[][] arr, int row, int col, int[][] strg) {

		if (row == arr.length || col == arr[0].length) {
			return Integer.MAX_VALUE;
		}

		if (row == arr.length - 1 && col == arr[0].length - 1) {
			return arr[row][col];
		}

		if (strg[row][col] != 0) {
			return strg[row][col];
		}

		int down = MPSTd(arr, row + 1, col, strg);
		int right = MPSTd(arr, row, col + 1, strg);

		int ans = Math.min(down, right) + arr[row][col];

		strg[row][col] = ans;

		return ans;

	}

	public static int MPSBU(int[][] grid) {

		int[][] strg = new int[grid.length][grid[0].length];

		for (int row = grid.length - 2; row >= 0; row--) {
			for (int col = grid[0].length - 2; col >= 0; col--) {
				strg[row][col] = Math.min(strg[row + 1][col], strg[row][col + 1]) + grid[row][col];
			}
		}

		for (int r = 0; r < strg.length; r++) {
			for (int c = 0; c < strg[0].length; c++) {
				System.out.print(strg[r][c] + "\t");
			}
			System.out.println();
		}

		return strg[0][0];
	}

}