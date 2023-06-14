package Practice_codechef;

import java.util.Scanner;

public class contestzinda2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();
		long[] d = new long[n];
		long[] s = new long[q];
		for (int i = 0; i < d.length; i++) {
			d[i] = scn.nextLong();
		}
		for (int i = 0; i < s.length; i++) {
			s[i] = scn.nextLong();
		}
		for (int i = 0; i < s.length; i++) {
			if (d[i] > s[i]) {
				System.out.println("-1");
			} else {
				System.out.println(d[i]);
			}
		}
	}
}