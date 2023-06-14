package hackerBlocks_DS;

import java.util.Scanner;
import java.util.Stack;

public class PlayingWithCards {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int q = s.nextInt();
		Stack<Integer> a0 = new Stack<>();
		for (int i = 0; i < n; i++) {
			a0.push(s.nextInt());
		}

		int[] primes = new int[q];
		int pcount = 0;
		int pi = 2;
		while (pcount < q) {
			if (isPrimes(pi)) {
				primes[pcount] = pi;
				pcount++;
			}
			pi++;
		}

		iterations(primes, a0, q);

		s.close();
	}

	public static void iterations(int[] primes, Stack<Integer> aim1, int q) {

		int ithitr = 0;
		Stack<Integer> ai = new Stack<>();
		while (q > 0) {
			Stack<Integer> b = new Stack<>();
			ai = new Stack<>();
			while (!aim1.isEmpty()) {
				int item = aim1.pop();
				int ithprime = primes[ithitr];

				if (item % ithprime == 0) {
					b.push(item);
				} else {
					ai.push(item);
				}
			}

			aim1 = ai;
			q--;
			ithitr++;

			while (!b.isEmpty()) {
				System.out.println(b.pop());
			}
			System.out.println();
		}
		while (!ai.isEmpty()) {
			System.out.println(ai.pop());
		}
	}

	public static boolean isPrimes(int n) {
		int i = 2;
		while (i * i <= n) {
			if (n % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
}