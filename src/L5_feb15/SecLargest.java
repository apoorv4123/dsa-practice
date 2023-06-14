package L5_feb15;

import java.util.Scanner;

public class SecLargest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = s.nextInt();
			int fac = 1;
			if (n == 1 || n == 0) {
				fac = 1;
			} else {
				for (int j = 1; j <= n; j++) {
					fac = fac * j;
				}
			}
			System.out.println(fac);
		}

	}

}
