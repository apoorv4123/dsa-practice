package striver_dp;

import java.util.Arrays;

public class fibonacci {

	public static void main(String[] args) {

		System.out.println(fib_rec(100));

		int n = 45;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);//-298632863
		System.out.println(fib_memoization(n, dp));
		
		System.out.println(fib_tabulation(n));
		
		System.out.println(fib_spaceOptimization(n));
	}
	
	public static int fib_rec(int n) {
		if(n <= 1) {
			return n;
		}
		int fn = fib_rec(n - 1) + fib_rec(n - 2);
		return fn;
	}

	public static int fib_memoization(int n, int[] dp) {
		if(n <= 1) {
			return n;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		int fn = fib_memoization(n - 1, dp) + fib_memoization(n - 2, dp);
		dp[n] = fn;
		return fn;
	}
	
	public static int fib_tabulation(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			int fn = dp[i - 1] + dp[i - 2];
			dp[i] = fn;
		}
		return dp[n];
	}
	
	public static int fib_spaceOptimization(int n) {
		int p2 = 0;
		int p = 1;
		for(int i = 2; i <= n; i++) {
			int curr = p2 + p;
			p2 = p;
			p = curr;
		}
		return p;
	}


}
