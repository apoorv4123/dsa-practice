package L9_feb29;

public class RecQuestions {

	public static void main(String[] args) {
		pdi(5);
		System.out.println(fac(4));
		System.out.println(power(2, 0));
		System.out.println(fib(4));
	}

	public static void pdi(int n) {
		if (n > 0) {
			System.out.println(n);
			pdi(n - 1);
			System.out.println(n);
		}
	}

	public static int fac(int n) {
		if (n == 1) {
			return 1;
		}
		int ans = fac(n - 1) * n;
		return ans;
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int ans = power(x, n - 1) * x;
		return ans;
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int fnm1 = fib(n - 1);
		int fnm2 = fib(n - 2);
		int ans = fnm1 + fnm2;
		return ans;
	}
}
