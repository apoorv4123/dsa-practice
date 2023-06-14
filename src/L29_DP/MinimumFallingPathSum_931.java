package L29_DP;

public class MinimumFallingPathSum_931 {

	public static void main(String[] args) {

		int[][] arr = { { 0, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int col = 0; col < arr[0].length; col++)
			System.out.println(MFPSRecursion(arr, 0, 0));
//		System.out.println(5 & 1); // 1

	}

	public static int MFPSRecursion(int[][] arr, int row, int col) {

		if (col < 0 || col == arr[0].length) {
			return Integer.MAX_VALUE;
		}

		if (row == arr.length) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int c = -1; c <= 1; c++) {

			int ans = MFPSRecursion(arr, row + 1, col + c);

			if (ans < min) {
				min = ans;
			}
		}
		return min + arr[row][col];
	}

}