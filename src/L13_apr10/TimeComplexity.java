package L13_apr10;

import java.util.Arrays;

public class TimeComplexity {

	public static void main(String[] args) {
//		System.out.println(power(2, 11));
//		System.out.println(computepoly(5, 3));
//		System.out.println(polynomial(3, 5));
		SOE(25);
	}

	public static int power(int n, int r) {
		if (r == 0) {
			return 1;
		}
		int sp = power(n, r / 2);
		if (r % 2 == 0)
			return sp * sp;
		else {
			return sp * sp * n;
		}
	}

//f(n,x)=1.x^n+2.x^(n-1)+3.x^(n-2)+4.x^(n-3)+.......+n.x in O(n)
	public static int computepoly(int n, int x) {
		int ans = 0;
		int part2 = power(x, n + 1);
		for (int part1 = 1; part1 <= n; part1++) {
			part2 /= x;
			ans += part1 * (part2);
		}
		return ans;
	}

	public static int polynomial(int x, int n) {
		int sum = 0;
		int mult = x;
		for (int coeff = n; coeff >= 1; coeff--) {
			sum += coeff * mult;
			mult *= x;
		}
		return sum;
	}

	// Sieve of Eratosthenese
	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table]) {

				for (int mult = 2; table * mult <= n; mult++) {
					primes[table * mult] = false;
				}

			}
		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}

	public static int countOfPalindromicSS(String str) {
		int count = 0;

		// odd length palindromic ss
		for (int axis = 0; axis < str.length() - 1; axis++) {

			int orbit = 0;
			while (axis - orbit >= 0 && axis + orbit <= str.length() - 1) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {

					count++;
				} else {

					break;
				}
				orbit++;
			}
		}

		// even length
		for (double axis = 0; axis < str.length() - 1; axis++) {

			double orbit = 0.5;
			while (axis - orbit >= 0 && axis + orbit <= str.length() - 1) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {

					count++;
				} else {

					break;
				}
				orbit++;
			}
		}
		return count;
	}

}