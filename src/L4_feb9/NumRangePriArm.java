package L4_feb9;

import java.util.Scanner;

public class NumRangePriArm {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int lo = s.nextInt();
		int hi = s.nextInt();
		PrintPrime(lo, hi);
		System.out.println("__________________________");
		PrintArmstrong(lo, hi);
	}

	public static void PrintPrime(int lo, int hi) {
		for (int n = lo; n <= hi; n++) {
			if (isPrime(n)) {
				System.out.println(n);
			}
		}
	}

	public static boolean isPrime(int n) {
		int i = 2;
		while (i * i <= n) {
			if (n % i == 0) {
				return false;
			} else {
				i = i + 1;
			}
		}
		return true;
	}

	public static void PrintArmstrong(int lo, int hi) {
		for (int n = lo; n <= hi; n++) {
			if (isArmstrong(n)) {
				System.out.println(n);
			}
		}
	}

	public static boolean isArmstrong(int n) {
		int num = n;
		int count = countDigits(n);
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += Math.pow(digit, count);//in this notation explicit typecasting is not required
			n /= 10;
		}
//		if (sum == num) 
//			return true;
//		else 
//			return false;
		return sum==num;
	}

	public static int countDigits(int n) {
		int count = 0;
		while (n > 0) {
			n = n / 10;
			count++;
		}
		return count;
	}
}
