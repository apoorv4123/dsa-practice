package Practice_codechef;

import java.util.Scanner;

public class contestzinda3 {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scn.nextInt();
		long[] d = new long[n];
		for (int i = 0; i < d.length; i++) {
			d[i] = scn.nextLong();
		}
		int pro = 1;
		for (int i = 1; i < d.length; i++) {
			if (d[i] > d[i - 1]) {
				pro++;
			}

		}
		pro++;
		if(pro>n) {
			pro--;
		}
		System.out.println(pro);
	}
}
