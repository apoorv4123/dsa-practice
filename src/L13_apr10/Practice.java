package L13_apr10;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
//		System.out.println(factorial(3));
//		System.out.println(power(2, 4));
//		System.out.println(fibonacci(5));
//		System.out.println(countBP(0, 10));

//		System.out.println(power2(2, 11));
//		System.out.println(polynomial(3, 5));

//		primeNosInRange(100);
//		SOE(100);

//		countPalinromicSS("nitin");
		System.out.println(countPalSS("nitinn"));

	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static int power(int a, int b) {// power function:O(n)
		if (b == 0) {
			return 1;
		}
		return a * power(a, b - 1);
	}

	public static int fibonacci(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int countBP(int curr, int last) {
		if (curr == last) {
			return 1;
		}
		if (curr > last) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			count += countBP(curr + i, last);
		}
		return count;
	}

	public static int power2(int a, int b) {// power function:O(log n)

		if (b == 0) {
			return 1;
		}
		int sp = power2(a, b / 2);
		if (b % 2 == 0) {
			return sp * sp;
			// return power2(s,b/2)*power2(s,b/2);
			// this is also right but it will also give time complexity of O(n)
		} else {
			return sp * sp * a;
		}
	}

	public static int polynomial(int x, int n) {

//		int ans = 0;
//		int part2 = (int) Math.pow(x, n);
//		for (int part1 = 1; part1 <= n; part1++) {
//			ans += part1 * part2;
//			part2 /= x;
//		}
//		return ans;

		// OR

		int res = 0;
		int multiplier = x;
		for (int coeff = n; coeff >= 1; coeff--) {
			res += coeff * multiplier;
			multiplier *= x;
		}
		return res;
	}

	public static void primeNosInRange(int n) {
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isPrime(int n) {
		int i = 2;
		while (i * i <= n) {
			if (n % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	public static void SOE(int n) {
		// Most efficient way to get all the prime nos present in a range
		// O(nloglogn)

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {

				primes[table * mult] = false;

			}
		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}

	}

	public static void countPalinromicSS(String str) {// O(n^3)

		int count = 0;

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);

				if (isPalinrome(ss)) {
					count++;
				}

			}
		}
	}

	public static boolean isPalinrome(String str) {

		for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return true;
	}

	public static int countPalSS(String str) {// O(n^2)

		int count = 0;
		// odd length palindromic substrings
		for (int axis = 0; axis < str.length(); axis++) {

			int orbit = 0;// initialise orbit
			while (axis - orbit >= 0 && axis + orbit < str.length()) {
				//for worst case i.e. when orbit is in mile of string then this loop
				//will work for n/2 an outer loop works for n so n*(n/2).
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					// jaise he aapke pass mismatch aa jaye then you don't have to grow your
					// orbit anymore
					break;
				}

				orbit++;
			}

		}

		// even length palindromic substrings
		for (double axis = 0.5; axis < str.length(); axis++) {

			double orbit = 0.5;// initialise orbit
			while (axis - orbit >= 0 && axis + orbit < str.length()) {
				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					// jaise he aapke pass mismatch aa jaye then you don't have to grow your
					// orbit anymore
					break;
				}

				orbit++;
			}

		}
		return count;
	}

}