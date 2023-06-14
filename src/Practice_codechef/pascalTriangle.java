package Practice_codechef;

import java.util.Scanner;

public class pascalTriangle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int row = 0;
		int nst = 0;
		int nsp = n - 1;
		while (row < n) {

			// spaces
			int csp = 1;
			for (csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			int cst = 0;
			while (cst <= row) {

				System.out.print(ncr(row, cst) + " ");
				cst++;
			}
			System.out.println();
			row++;
			nsp--;
		}
	}

	public static int ncr(int n, int r) {
		r = Math.min(r, n - r);
		return (fac(n) / (fac(r) * fac(n - r)));
	}

	public static int fac(int num) {
		if (num == 1 || num == 0) {
			return 1;
		} else {
			int i = 1, pro = 1;
			while (i <= num) {
				pro = pro * i;
				i++;
			}
			return pro;
		}

	}
}