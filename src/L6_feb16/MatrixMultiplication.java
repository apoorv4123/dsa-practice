package L6_feb16;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int[][] one = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] two = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
//		int[][] res = matrixProduct(one, two);
		int[][] res = matmux(one, two);
		display(res);
	}

	public static void display(int[][] arr) {
		for (int[] val : arr) {
			for (int val1 : val) {
				System.out.print(val1 + " ");
			}
			System.out.println();
		}
	}

	public static int[][] matrixProduct(int[][] one, int[][] two) {
		int[][] res = new int[one.length][two[0].length];
		for (int row = 0; row < one.length; row++) {
			for (int col = 0; col < two[0].length; col++) {
				for (int k = 0; k < two.length; k++) {
					res[row][col] += one[row][k] * two[k][col];
				}
			}
		}
		return res;
	}

	public static int[][] matmux(int[][] one, int[][] two) {
		int[][] ans = new int[one.length][two[0].length];
		for (int row = 0; row < one.length; row++) {
			for (int col = 0; col < two[0].length; col++) {
				for (int i = 0; i < one[0].length; i++) {
					ans[row][col] += one[row][i] * two[i][col];
				}
			}
		}
		return ans;
	}
}
