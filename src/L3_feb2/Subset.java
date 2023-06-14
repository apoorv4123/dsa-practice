package L3_feb2;

import java.util.Scanner;

public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1, num = n, place = 10;

		int nod = 0;

		// count no of digits
		while (num > 0) {
			nod = nod + 1;
			num = num / 10;
		}

		while (i <= (int) Math.pow(2, nod)) {
			while (n > 0) {
				int digit = n % place;
				n = n / place;
				System.out.println(digit);
			}
			place = place * 10;
			i = i + 1;
		}
	}
}
